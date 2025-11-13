from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from auth import get_db, authenticate_admin, create_access_token
from pydantic import BaseModel

# # Initialize admin at startup
# init_admin()

router = APIRouter()

class AdminLogin(BaseModel):
    email: str
    password: str


@router.post("/login")
def admin_login(request: AdminLogin, db: Session = Depends(get_db)):
    user = authenticate_admin(request.email, request.password, db)
    if not user:
        raise HTTPException(status_code=401, detail="Invalid credentials")
    token = create_access_token({"email": user.email,"is_admin": user.is_admin})
    return {"access_token": token, "token_type": "bearer"}



# from fastapi import APIRouter, Depends, HTTPException
# from sqlalchemy.orm import Session
# from auth import get_db, authenticate_admin, init_admin, create_access_token,get_password_hash
# from schemas import Token, AuthRequest
# from models import User

# router = APIRouter()
# init_admin()

# @router.post("/login", response_model=Token)
# def login(creds: AuthRequest, db: Session = Depends(get_db)):
#     user = authenticate_admin(creds.email, creds.password, db)
#     if not user:
#         raise HTTPException(status_code=401, detail="Invalid credentials or not admin")
#     token = create_access_token({"sub": user.email, "is_admin": user.is_admin})
#     return {"access_token": token, "token_type": "bearer"}

# # ------------- Create Admin -------------
# @router.post("/create-admin")
# def create_admin(creds: AuthRequest, db: Session = Depends(get_db)):
#     # Check if email already exists
#     existing = db.query(User).filter(User.email == creds.email).first()
#     if existing:
#         raise HTTPException(status_code=400, detail="Email already exists")

#     # Hash password and create admin
#     hashed = get_password_hash(creds.password)
#     admin = User(email=creds.email, hashed_password=hashed, is_admin=1)
#     db.add(admin)
#     db.commit()       # must commit to save to DB
#     db.refresh(admin) # optional, get auto-generated id

#     return {"message": "Admin created", "id": admin.id}