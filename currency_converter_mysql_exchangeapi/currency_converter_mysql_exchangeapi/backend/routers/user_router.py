from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import get_db
from models import User, ConversionLog
from schemas import ConvertRequest, ConvertResponse
from auth import hash_password, verify_password, create_access_token, decode_access_token, oauth2_scheme
from pydantic import BaseModel
from routers import user_router
import re


router = APIRouter()


# ✅ Define schema for register/login
class UserAuth(BaseModel):
    email: str
    password: str


# ✅ User Registration
# @router.post("/register")
# def register_user(data: UserAuth, db: Session = Depends(get_db)):
#     if not re.match(r"[^@]+@[^@]+\.[^@]+", data.email):
#         raise HTTPException(status_code=400, detail="Invalid email format")

#     existing = db.query(User).filter(User.email == data.email).first()
#     if existing:
#         raise HTTPException(status_code=400, detail="Email already registered")

#     hashed_password = hash_password(data.password)
#     new_user = User(email=data.email, hashed_password=hashed_password, is_admin=0)
#     db.add(new_user)
#     db.commit()
#     db.refresh(new_user)
#     return {"message": "User registered successfully"}

@router.post("/register")
def register_user(data: UserAuth, db: Session = Depends(get_db)):
    email = data.email
    password = data.password

    # --------- Email validations ----------
    if not email:
        raise HTTPException(status_code=400, detail="Email is required")
    
    if "@" not in email:
        raise HTTPException(status_code=400, detail="Email must contain '@'")
    
    parts = email.split("@")
    if len(parts) != 2:
        raise HTTPException(status_code=400, detail="Email must contain exactly one '@'")
    
    local_part, domain_part = parts
    if "." not in domain_part:
        raise HTTPException(status_code=400, detail="Email domain must contain '.'")
    
    if " " in email:
        raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    
    pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    if not re.match(pattern, email):
        raise HTTPException(status_code=400, detail="Email format is invalid (e.g., user@example.com)")

    # --------- Password validations ----------
    if not password:
        raise HTTPException(status_code=400, detail="Password is required")
    
    if len(password) < 6:
        raise HTTPException(status_code=400, detail="Password must be at least 6 characters long")

    # --------- Existing email check ----------
    existing = db.query(User).filter(User.email == email).first()
    if existing:
        raise HTTPException(status_code=400, detail="Email already registered")

    # --------- Create user ----------
    hashed_password = hash_password(password)
    new_user = User(email=email, hashed_password=hashed_password, is_admin=0)
    db.add(new_user)
    db.commit()
    db.refresh(new_user)

    return {"message": "User registered successfully"}


# ✅ User Login
@router.post("/login")
def login_user(data: UserAuth, db: Session = Depends(get_db)):
    user = db.query(User).filter(User.email == data.email).first()
    if not user or not verify_password(data.password, user.hashed_password):
        raise HTTPException(status_code=401, detail="Invalid email or password")

    if user.is_admin == 1:
        raise HTTPException(status_code=403, detail="Admins must use /admin/login")

    token = create_access_token({"email": user.email, "user_id": user.id, "is_admin": False})
    return {"access_token": token, "token_type": "bearer"}


# ✅ Current User Dependency
def get_current_user(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)):
    payload = decode_access_token(token)
    user = db.query(User).filter(User.email == payload.get("email")).first()
    if not user:
        raise HTTPException(status_code=401, detail="User not found")
    return user


# ✅ Convert endpoint
@router.post("/convert", response_model=ConvertResponse)
def convert_currency(
    req: ConvertRequest,
    db: Session = Depends(get_db),
    current_user: User = Depends(get_current_user)
):
    if not current_user:
        raise HTTPException(status_code=401, detail="Unauthorized user")

    # Example placeholder conversion logic
    conversion = ConversionLog(
        user_id=current_user.id,
        from_currency=req.from_currency,
        to_currency=req.to_currency,
        amount=req.amount,
        result=req.amount * 83.0  # example fixed rate
    )
    db.add(conversion)
    db.commit()
    db.refresh(conversion)

    return {
        "from_currency": req.from_currency,
        "to_currency": req.to_currency,
        "amount": req.amount,
        "result": conversion.result
    }


# ✅ Get user conversions
@router.get("/conversions")
def get_conversions(
    db: Session = Depends(get_db),
    current_user: User = Depends(get_current_user)
):
    if not current_user:
        raise HTTPException(status_code=401, detail="Unauthorized user")

    conversions = db.query(ConversionLog).filter(
        ConversionLog.user_id == current_user.id
    ).all()
    return conversions





# from fastapi import APIRouter, Depends, HTTPException
# from sqlalchemy.orm import Session
# from database import get_db
# from models import User, ConversionLog
# from schemas import UserCreate, UserOut, ConversionCreate, ConversionOut
# from auth import hash_password, verify_password, create_access_token, decode_access_token
# from fastapi.security import OAuth2PasswordBearer
# import requests

# router = APIRouter(prefix="/user", tags=["User"])
# # router = APIRouter()

# oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")
# EXCHANGE_API_KEY = "0d162a229870b719134c8e58"


# @router.post("/register", response_model=UserOut)
# def register(user: UserCreate, db: Session = Depends(get_db)):
#     db_user = db.query(User).filter(User.email == user.email).first()
#     if db_user:
#         raise HTTPException(status_code=400, detail="Email already registered")
#     new_user = User(email=user.email, hashed_password=hash_password(user.password))
#     db.add(new_user)
#     db.commit()
#     db.refresh(new_user)
#     return new_user


# @router.post("/login")
# def login(user: UserCreate, db: Session = Depends(get_db)):
#     db_user = db.query(User).filter(User.email == user.email).first()
#     if not db_user or not verify_password(user.password, db_user.hashed_password):
#         raise HTTPException(status_code=401, detail="Invalid credentials")
#     token = create_access_token({"user_id": db_user.id})
#     return {"access_token": token, "token_type": "bearer"}


# def get_current_user(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)):
#     payload = decode_access_token(token)
#     user = db.query(User).filter(User.id == payload.get("user_id")).first()
#     if not user:
#         raise HTTPException(status_code=401, detail="User not found")
#     return user


# @router.post("/convert", response_model=ConversionOut)
# def convert_currency(data: ConversionCreate, db: Session = Depends(get_db), user: User = Depends(get_current_user)):
#     url = f"https://v6.exchangerate-api.com/v6/{EXCHANGE_API_KEY}/pair/{data.from_currency}/{data.to_currency}/{data.amount}"
#     response = requests.get(url).json()
#     if response.get("result") != "success":
#         raise HTTPException(status_code=400, detail="Conversion failed")

#     rate = response["conversion_rate"]
#     result = response["conversion_result"]

#     conversion = ConversionLog(
#         user_id=user.id,
#         from_currency=data.from_currency,
#         to_currency=data.to_currency,
#         amount=data.amount,
#         result=result,
#         rate=rate,
#         raw_response=str(response)
#     )
#     db.add(conversion)
#     db.commit()
#     db.refresh(conversion)
#     return conversion


# @router.get("/conversions", response_model=list[ConversionOut])
# def conversions(db: Session = Depends(get_db), user: User = Depends(get_current_user)):
#     return db.query(ConversionLog).filter(ConversionLog.user_id == user.id).order_by(ConversionLog.id.desc()).all()
