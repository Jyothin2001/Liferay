# auth.py
import os, datetime, jwt
from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
from sqlalchemy.orm import Session
from database import SessionLocal
from models import User
from passlib.context import CryptContext
from dotenv import load_dotenv

load_dotenv()

JWT_SECRET = os.getenv("JWT_SECRET", "change_this_secret")
pwd_ctx = CryptContext(schemes=["pbkdf2_sha256"], deprecated="auto")
oauth2_scheme = OAuth2PasswordBearer(tokenUrl="/admin/login")
# Client login token endpoint
user_oauth2_scheme = OAuth2PasswordBearer(tokenUrl="/user/login")

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

def get_password_hash(password: str):
    return pwd_ctx.hash(password)

def verify_password(password: str, hashed: str):
    return pwd_ctx.verify(password, hashed)

def create_access_token(data: dict, expires_minutes: int = 60*24):
    to_encode = data.copy()
    expire = datetime.datetime.utcnow() + datetime.timedelta(minutes=expires_minutes)
    to_encode.update({"exp": expire})
    return jwt.encode(to_encode, JWT_SECRET, algorithm="HS256")

def authenticate_admin(email: str, password: str, db: Session):
    user = db.query(User).filter(User.email == email).first()
    if not user or user.is_admin != 1:
        return None
    if not verify_password(password, user.hashed_password):
        return None
    return user

def get_current_admin(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)):
    try:
        payload = jwt.decode(token, JWT_SECRET, algorithms=["HS256"])
        if not payload.get("is_admin"):
            raise HTTPException(status_code=403, detail="Not admin")
        user = db.query(User).filter(User.email == payload.get("sub")).first()
        if not user or user.is_admin != 1:
            raise HTTPException(status_code=401, detail="Admin not found")
        return user
    except jwt.ExpiredSignatureError:
        raise HTTPException(status_code=401, detail="Token expired")
    except jwt.InvalidTokenError:
        raise HTTPException(status_code=401, detail="Invalid token")

def create_default_admin(db: Session):
    admin_email = os.getenv("ADMIN_EMAIL", "admin@gmail.com")
    admin_password = os.getenv("ADMIN_PASSWORD", "admin123")

    admin = db.query(User).filter(User.email == admin_email, User.is_admin == 1).first()
    if not admin:
        hashed_password = get_password_hash(admin_password)
        new_admin = User(
            email=admin_email,
            hashed_password=hashed_password,
            is_admin=1
        )
        db.add(new_admin)
        db.commit()
        print(f"✅ Admin '{admin_email}' created successfully.")

def admin_required(admin = Depends(get_current_admin)):
    if not admin:
        raise HTTPException(status_code=403, detail="Admin access required")
    return admin


# User
JWT_SECRET = "your-secret-key"
pwd_ctx = CryptContext(schemes=["bcrypt"], deprecated="auto")

def hash_password(password: str):
    return pwd_ctx.hash(password)

def verify_password(password, hashed):
    return pwd_ctx.verify(password, hashed)

def create_access_token(data: dict, expires_minutes: int = 60*24):
    to_encode = data.copy()
    expire = datetime.datetime.utcnow() + datetime.timedelta(minutes=expires_minutes)
    to_encode.update({"exp": expire})
    return jwt.encode(to_encode, JWT_SECRET, algorithm="HS256")

def decode_access_token(token: str):
    try:
        payload = jwt.decode(token, JWT_SECRET, algorithms=["HS256"])
        return payload
    except Exception:
        raise HTTPException(status_code=401, detail="Invalid or expired token")


def get_current_user(token: str = Depends(user_oauth2_scheme), db: Session = Depends(get_db)):
    """Validate client JWT token and return current user."""
    try:
        payload = jwt.decode(token, JWT_SECRET, algorithms=["HS256"])
        email = payload.get("email")
        if not email:
            raise HTTPException(status_code=401, detail="Invalid token: no email found")

        # Ensure this is a normal client (not admin)
        user = db.query(User).filter(User.email == email, User.is_admin == 0).first()
        if not user:
            raise HTTPException(status_code=401, detail="User not found or unauthorized")
        return user

    except jwt.ExpiredSignatureError:
        raise HTTPException(status_code=401, detail="Token expired")
    except jwt.InvalidTokenError:
        raise HTTPException(status_code=401, detail="Invalid token")
    
    