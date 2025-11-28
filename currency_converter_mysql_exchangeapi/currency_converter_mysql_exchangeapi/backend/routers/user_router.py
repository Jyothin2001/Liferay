from fastapi import APIRouter, Depends, HTTPException,BackgroundTasks
from sqlalchemy.orm import Session
from database import get_db
from models import User, ConversionLog
from schemas import ConvertRequest, ConvertResponse,ForgotPasswordRequest,ResetPasswordRequest
from auth import hash_password, verify_password, create_access_token, decode_access_token, oauth2_scheme
from pydantic import BaseModel
from routers import user_router
import re
from services.exchange_service import fetch_rate_pair
from email_utils import send_registration_email, send_reset_password_email
import asyncio
from crud import reset_password,set_reset_token



router = APIRouter()


# ✅ Define schema for register/login
class UserAuth(BaseModel):
    email: str
    password: str

# ---------------- Strong password regex ----------------
PASSWORD_PATTERN = r"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
EMAIL_PATTERN = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"


@router.post("/register")
def register_user(
    data: UserAuth,
    db: Session = Depends(get_db),
    background_tasks: BackgroundTasks = None
):
    email = data.email
    password = data.password

    # -------- Email validation --------
    if not email:
        raise HTTPException(status_code=400, detail="Email is required")
    if " " in email:
        raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    if not re.match(EMAIL_PATTERN, email):
        raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

    # -------- Password validation --------
    if not password:
        raise HTTPException(status_code=400, detail="Password is required")
    if " " in password:
        raise HTTPException(status_code=400, detail="password cannot contain spaces")
    if not re.match(PASSWORD_PATTERN, password):
        raise HTTPException(
            status_code=400,
            detail="Password must be at least 8 characters, contain uppercase and lowercase letters, "
                   "a number, and a special character (@$!%*?&)"
        )

    # -------- Check existing email --------
    existing_user = db.query(User).filter(User.email == email).first()
    if existing_user:
        raise HTTPException(status_code=400, detail="Email already registered")

    # -------- Create user --------
    hashed_password = hash_password(password)
    new_user = User(email=email, hashed_password=hashed_password, is_admin=0)
    db.add(new_user)
    db.commit()
    db.refresh(new_user)

    # -------- Send registration email --------
    if background_tasks:
        background_tasks.add_task(send_registration_email, new_user.email, new_user.email.split("@")[0])

    return {"message": "User registered successfully"}


# ---------------- LOGIN ---------------------
@router.post("/login")
def login_user(data: UserAuth, db: Session = Depends(get_db)):
    email = data.email
    password = data.password

    # -------- Input validations --------
    if not email:
        raise HTTPException(status_code=400, detail="Email is required")
    if " " in email:
        raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    if not re.match(EMAIL_PATTERN, email):
        raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

    if not password:
        raise HTTPException(status_code=400, detail="Password is required")
    if " " in password:
        raise HTTPException(status_code=400, detail="password cannot contain spaces")
    if not re.match(PASSWORD_PATTERN, password):
        raise HTTPException(
            status_code=400,
            detail="Password must be at least 8 characters, contain uppercase and lowercase letters, "
                   "a number, and a special character (@$!%*?&)"
        )

    # -------- Fetch user from DB --------
    user = db.query(User).filter(User.email == email).first()
    user = db.query(User).filter(User.email == email).first()  # Exact match
    print("Login attempt:", email)
    print("Stored hash:", user.hashed_password if user else None)

    # -------- Verify password --------
    if not user or not verify_password(password, user.hashed_password):
        print("Password verification failed or user not found")
        raise HTTPException(status_code=401, detail="Invalid email or password")

    # -------- Create access token --------
    token = create_access_token({"email": user.email, "user_id": user.id, "is_admin": user.is_admin})
    return {"access_token": token, "token_type": "bearer"}

# @router.post("/register")
# def register_user(data: UserAuth, db: Session = Depends(get_db), background_tasks: BackgroundTasks = None):
#     email = data.email
#     password = data.password

#     # --------- Email validations ----------
#     if not email:
#         raise HTTPException(status_code=400, detail="Email is required")
    
#     if "@" not in email:
#         raise HTTPException(status_code=400, detail="Email must contain '@'")
    
#     parts = email.split("@")
#     if len(parts) != 2:
#         raise HTTPException(status_code=400, detail="Email must contain exactly one '@'")
    
#     local_part, domain_part = parts
#     if "." not in domain_part:
#         raise HTTPException(status_code=400, detail="Email domain must contain '.'")
    
#     if " " in email:
#         raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    
#     pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
#     if not re.match(pattern, email):
#         raise HTTPException(status_code=400, detail="Email format is invalid (e.g., user@example.com)")

#     # --------- Password validations ----------
#     if not password:
#         raise HTTPException(status_code=400, detail="Password is required")
    
#     if len(password) < 6:
#         raise HTTPException(status_code=400, detail="Password must be at least 6 characters long")

#     # --------- Existing email check ----------
#     existing = db.query(User).filter(User.email == email).first()
#     if existing:
#         raise HTTPException(status_code=400, detail="Email already registered")

#     # --------- Create user ----------
#     hashed_password = hash_password(password)
#     new_user = User(email=email, hashed_password=hashed_password, is_admin=0)
#     db.add(new_user)
#     db.commit()
#     db.refresh(new_user)
#     background_tasks.add_task(send_registration_email, new_user.email, new_user.email.split("@")[0])


#     return {"message": "User registered successfully"}


# # ✅ User Login
# # @router.post("/login")
# # def login_user(data: UserAuth, db: Session = Depends(get_db)):
# #     user = db.query(User).filter(User.email == data.email).first()
# #     if not user or not verify_password(data.password, user.hashed_password):
# #         raise HTTPException(status_code=401, detail="Invalid email or password")

# #     if user.is_admin == 1:
# #         raise HTTPException(status_code=403, detail="Admins must use /admin/login")

# #     token = create_access_token({"email": user.email, "user_id": user.id, "is_admin": False})
# #     return {"access_token": token, "token_type": "bearer"}

# # @router.post("/login")
# # def login_user(data: UserAuth, db: Session = Depends(get_db)):
# #     user = db.query(User).filter(User.email == data.email).first()
# #     print("Login attempt:", data.email, data.password)
# #     print("Stored hash:", user.hashed_password if user else None)
# #     if not user or not verify_password(data.password, user.hashed_password):
# #         print("Verify failed")
# #         raise HTTPException(status_code=401, detail="Invalid email or password")

# #     token = create_access_token({"email": user.email, "user_id": user.id, "is_admin": False})
# #     return {"access_token": token, "token_type": "bearer"}

# @router.post("/login")
# def login_user(data: UserAuth, db: Session = Depends(get_db)):
#     email = data.email
#     password = data.password

#    # -------- Input validations --------
#     if not email:
#         raise HTTPException(status_code=400, detail="Email is required")
#     if " " in email:
#         raise HTTPException(status_code=400, detail="Email cannot contain spaces")
    
#     # -------- Regex email validation --------
#     pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
#     if not re.match(pattern, email):
#         raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

#     if not password:
#         raise HTTPException(status_code=400, detail="Password is required")
#     if len(password) < 6:
#         raise HTTPException(status_code=400, detail="Password must be at least 6 characters long")


#     # -------- Fetch user from DB --------
#     user = db.query(User).filter(User.email == email).first()
#     print("Login attempt:", email, password)
#     print("Stored hash:", user.hashed_password if user else None)

#     # -------- Verify password --------
#     if not user or not verify_password(password, user.hashed_password):
#         print("Password verification failed or user not found")
#         raise HTTPException(status_code=401, detail="Invalid email or password")

#     # -------- Create access token --------
#     token = create_access_token({"email": user.email, "user_id": user.id, "is_admin": user.is_admin})
#     return {"access_token": token, "token_type": "bearer"}

# ✅ Current User Dependency
def get_current_user(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)):
    payload = decode_access_token(token)
    user = db.query(User).filter(User.email == payload.get("email")).first()
    if not user:
        raise HTTPException(status_code=401, detail="User not found")
    return user


@router.post("/convert", response_model=ConvertResponse)
def convert_currency(
    req: ConvertRequest,
    db: Session = Depends(get_db),
    current_user: User = Depends(get_current_user)
):
    if not current_user:
        raise HTTPException(status_code=401, detail="Unauthorized user")

    # Fetch real-time rate dynamically
    try:
        rate, raw = fetch_rate_pair(req.from_currency.upper(), req.to_currency.upper())
        if rate is None:
            raise HTTPException(status_code=400, detail="Rate not found")
    except Exception as e:
        raise HTTPException(status_code=400, detail=f"Error fetching rate: {str(e)}")

    # Calculate result dynamically
    result = round(req.amount * rate, 6)

    # Save conversion in DB
    conversion = ConversionLog(
        user_id=current_user.id,
        from_currency=req.from_currency.upper(),
        to_currency=req.to_currency.upper(),
        amount=req.amount,
        result=result,
        rate=rate,
        raw_response=str(raw)
    )
    db.add(conversion)
    db.commit()
    db.refresh(conversion)

    # Return response
    return {
        "from_currency": req.from_currency.upper(),
        "to_currency": req.to_currency.upper(),
        "amount": req.amount,
        "result": result,
        "rate": rate
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


# ---------------- EMAIL SENDER FOR RESET LINK ----------------
async def send_password_reset_email(email: str, reset_token: str):
    reset_link = f"http://192.168.0.102:3000/reset-password?token={reset_token}"

    from fastapi_mail import FastMail, MessageSchema
    from email_utils import conf

    message = MessageSchema(
        subject="CurrencyX — Reset Your Password",
        recipients=[email],
        body=(
            f"Hello,\n\n"
            f"Click the link below to reset your password:\n{reset_link}\n\n"
            f"If you did not request this, ignore this email."
        ),
        subtype="plain"
    )

    fm = FastMail(conf)
    await fm.send_message(message)


from pydantic import BaseModel


# ---------------- FORGOT PASSWORD ----------------
@router.post("/forgot-password")
async def forgot_password(req: ForgotPasswordRequest, db: Session = Depends(get_db)):
    token = set_reset_token(db, req.email)
    if not token:
        raise HTTPException(status_code=404, detail="Email not found")

    try:
        await send_reset_password_email(req.email, token)
    except Exception as e:
        print(f"[Email ERROR] Failed to send gg reset link: {e}")  # log actual error
        raise HTTPException(status_code=500, detail="Failed to send reset link")

    return {"message": "Reset link sent to email"}







@router.post("/reset-password")
def reset_pass(req: ResetPasswordRequest, db: Session = Depends(get_db)):
    success = reset_password(db, req.token, req.new_password)
    if not success:
        raise HTTPException(status_code=400, detail="Invalid or expired token")
    return {"message": "Password updated successfully"}
