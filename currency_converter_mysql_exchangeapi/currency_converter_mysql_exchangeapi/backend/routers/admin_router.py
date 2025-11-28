from fastapi import APIRouter, Depends, HTTPException, Header,Query
from sqlalchemy.orm import Session
from auth import get_db, authenticate_admin, create_access_token
from pydantic import BaseModel,Field
from typing import List
import jwt, os
from crud import get_recent_conversions
from schemas import ConversionLogOut,UserOut
from models import ConversionLog
from auth import get_current_admin, get_db,admin_required
from datetime import datetime, timedelta
from models import User
from schemas import AuthRequest
from auth import verify_password
from re import match
from sqlalchemy import cast, Date,func

router = APIRouter()

JWT_SECRET = os.getenv("JWT_SECRET", "change_this_secret")


# -----------------------------
# Request model for admin login
# -----------------------------
class AdminLogin(BaseModel):
    email: str
    password: str

@router.post("/login")
def admin_login(request: AdminLogin, db: Session = Depends(get_db)):

    # ------------------------
    # 1️⃣ Validate email manually
    # ------------------------
    if not request.email:
        raise HTTPException(status_code=400, detail="Email is required")
    if " " in request.email:
        raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    
    # simple regex for email format
    pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    if not match(pattern, request.email):
        raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

    # ------------------------
    # 2️⃣ Validate password
    # ------------------------
    if not request.password:
        raise HTTPException(status_code=400, detail="Password is required")
    if " " in request.password:
        raise HTTPException(status_code=400, detail="Password cannot contain spaces")

    # ------------------------
    # 3️⃣ Check admin in DB (case-sensitive email)
    # ------------------------
    user = db.query(User).filter(User.email == request.email).first()  # exact match
    if not user or user.is_admin != 1:
        raise HTTPException(status_code=403, detail="Only admin accounts can log in here")

    if not verify_password(request.password, user.hashed_password):
        raise HTTPException(status_code=401, detail="Invalid credentials")

    # ------------------------
    # 4️⃣ Create access token
    # ------------------------
    access_token = create_access_token({"sub": user.email, "is_admin": True})

    return {"message": "Login successful", "access_token": access_token, "token_type": "bearer"}

# @router.post("/login")
# def admin_login(request: AdminLogin, db: Session = Depends(get_db)):

#     # ------------------------
#     # 1️⃣ Validate email manually
#     # ------------------------
#     if not request.email:
#         raise HTTPException(status_code=400, detail="Email is required")
    
#     # simple regex for email format
#     pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
#     if not match(pattern, request.email):
#         raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

#     # ------------------------
#     # 2️⃣ Validate password
#     # ------------------------
#     if not request.password:
#         raise HTTPException(status_code=400, detail="Password is required")

#     # ------------------------
#     # 3️⃣ Check admin in DB
#     # ------------------------
#     user = db.query(User).filter(User.email == request.email).first()
#     if not user or user.is_admin != 1:
#         raise HTTPException(status_code=403, detail="Only admin accounts can log in here")

#     if not verify_password(request.password, user.hashed_password):
#         raise HTTPException(status_code=401, detail="Invalid credentials")

#     # ------------------------
#     # 4️⃣ Create access token
#     # ------------------------
#     access_token = create_access_token({"sub": user.email, "is_admin": True})

#     return {"message": "Login successful", "access_token": access_token, "token_type": "bearer"}


# Example:
# @router.post("/login")
# def admin_login(request: AuthRequest, db: Session = Depends(get_db)):
#     user = db.query(User).filter(User.email == request.email).first()

#     # ✅ Add this validation
#     if not user or user.is_admin != 1:
#         raise HTTPException(status_code=403, detail="Only admin accounts can log in here")

#     if not verify_password(request.password, user.hashed_password):
#         raise HTTPException(status_code=401, detail="Invalid credentials")

#     access_token = create_access_token({"sub": user.email})
#     return {"access_token": access_token, "token_type": "bearer"}


# -----------------------------
# # Dependency to get current admin
# # -----------------------------
# def get_current_admin(authorization: str = Header(None), db: Session = Depends(get_db)):
#     if not authorization:
#         raise HTTPException(status_code=401, detail="Missing Authorization header")

#     parts = authorization.split()
#     if len(parts) != 2 or parts[0].lower() != "bearer":
#         raise HTTPException(status_code=401, detail="Invalid Authorization header")
         
#     token = parts[1]
#     try:
#         data = jwt.decode(token, JWT_SECRET, algorithms=["HS256"])
#         if not bool(data.get("is_admin")):
#             raise HTTPException(status_code=403, detail="Not admin")
#         return data
#     except jwt.ExpiredSignatureError:
#         raise HTTPException(status_code=401, detail="Token expired")
#     except jwt.InvalidTokenError:
#         raise HTTPException(status_code=401, detail="Invalid token")

class ConversionLogOut(BaseModel):
    id: int
    timestamp: datetime
    base_currency: str = Field(..., alias="from_currency")
    target_currency: str = Field(..., alias="to_currency")
    amount: float
    converted_amount: float = Field(..., alias="result")
    rate: float

    model_config = {
        "from_attributes": True  # <-- tells Pydantic to read from SQLAlchemy models
    }

    

def get_recent_conversions(db: Session, limit: int = 50):
    return db.query(ConversionLog).order_by(ConversionLog.id.desc()).limit(limit).all()

# @router.get("/conversions", response_model=List[ConversionLogOut])
# def recent_conversions(limit: int = 70, db: Session = Depends(get_db)):
#     """
#     Accessible only by admin users with valid Bearer token....
#     """
#     return get_recent_conversions(db, limit)





@router.get(
    "/conversions",
    response_model=List[ConversionLogOut],
    dependencies=[Depends(get_current_admin)]
)
def recent_conversions(
   
    start_date: str | None = Query(None),
    end_date: str | None = Query(None),
    from_currency: str | None = Query(None),
    to_currency: str | None = Query(None),
    min_amount: float | None = Query(None),
    max_amount: float | None = Query(None),
    db: Session = Depends(get_db),
):

    query = db.query(ConversionLog)

    # ---- DATE FILTERING (PERFECTLY ACCURATE) ----
    if start_date:
        query = query.filter(
            cast(ConversionLog.timestamp, Date) >= start_date
        )

    if end_date:
        query = query.filter(
            cast(ConversionLog.timestamp, Date) <= end_date
        )

    # ---- CURRENCY FILTERS ----
    if from_currency:
        query = query.filter(
            func.upper(ConversionLog.from_currency) == from_currency.upper().strip()
        )

    if to_currency:
        query = query.filter(
            func.upper(ConversionLog.to_currency) == to_currency.upper().strip()
        )
# ---- AMOUNT RANGE FILTER ----
    if min_amount is not None:
        query = query.filter(ConversionLog.amount >= min_amount)

    if max_amount is not None:
        query = query.filter(ConversionLog.amount <= max_amount)
    # =============
    #  SORT & LIMIT
    # =============
    return query.order_by(ConversionLog.id.desc()).all()

@router.delete("/delete_conversion/{log_id}")
def delete_conversion(log_id: int, db: Session = Depends(get_db), admin=Depends(admin_required)):
    log = db.query(ConversionLog).filter(ConversionLog.id == log_id).first()

    if not log:
        raise HTTPException(status_code=404, detail="Conversion log not found")
    
    db.delete(log)
    db.commit()
    return {"message": "Log deleted successfully", "id": log_id}

@router.get("/users", response_model=List[UserOut], dependencies=[Depends(admin_required)])
def get_users(db: Session = Depends(get_db)):
    return db.query(User).filter(User.is_admin == 0).all()