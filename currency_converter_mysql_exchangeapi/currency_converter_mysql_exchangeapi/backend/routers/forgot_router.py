from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import get_db
from schemas import ForgotPasswordRequest, ResetPasswordRequest
from models import User
from auth import hash_password
import uuid

router = APIRouter()

# temporary token store (use Redis/DB in production)
reset_tokens = {}


# ----------------------------------------------------
#  SEND RESET LINK
# ----------------------------------------------------
# @router.post("/forgot-password")
# def forgot_password(req: ForgotPasswordRequest, db: Session = Depends(get_db)):
#     user = db.query(User).filter(User.email == req.email).first()

#     if not user:
#         raise HTTPException(status_code=404, detail="Email not found")

#     # generate token
#     token = str(uuid.uuid4())
#     reset_tokens[token] = user.email

#     print("\n--------------------------------")
#     print("🔗 PASSWORD RESET LINK (TESTING)")
#     print(f"http://localhost:5173/reset-password?token={token}")
#     print("--------------------------------\n")

#     return {"message": "Password reset link sent to email."}

from re import match

@router.post("/forgot-password")
def forgot_password(req: ForgotPasswordRequest, db: Session = Depends(get_db)):
    email = req.email

    # ---------- VALIDATION ----------
    if not email or email.strip() == "":
        raise HTTPException(status_code=400, detail="Email is required")

    if " " in email:
        raise HTTPException(status_code=400, detail="Email cannot contain spaces")

    pattern = r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    if not match(pattern, email):
        raise HTTPException(status_code=400, detail="Invalid email format (e.g., user@example.com)")

    # Normalize email to lowercase for consistent lookup
    email = email.lower()

    user = db.query(User).filter(User.email == email).first()
    if not user:
        raise HTTPException(status_code=404, detail="Email not found")

    # generate token
    token = str(uuid.uuid4())
    reset_tokens[token] = user.email

    print("\n--------------------------------")
    print("🔗 PASSWORD RESET LINK (TESTING)")
    print(f"http://localhost:5173/reset-password?token={token}")
    print("--------------------------------\n")

    return {"message": "Password reset link sent to email."}


# ----------------------------------------------------
#  RESET PASSWORD
# ----------------------------------------------------
# @router.post("/reset-password")
# def reset_password(req: ResetPasswordRequest, db: Session = Depends(get_db)):
#     if req.token not in reset_tokens:
#         raise HTTPException(status_code=400, detail="Invalid or expired token")

#     email = reset_tokens[req.token]

#     user = db.query(User).filter(User.email == email).first()
#     if not user:
#         raise HTTPException(status_code=404, detail="User not found")

#     user.hashed_password = hash_password(req.new_password)
#     db.commit()

#     # delete token after use
#     del reset_tokens[req.token]

#     return {"message": "Password updated successfully"}

import re

@router.post("/reset-password")
def reset_password(req: ResetPasswordRequest, db: Session = Depends(get_db)):
    
    token = req.token.strip()  
    new_password = req.new_password

    # ---------- TOKEN CHECK ----------
    if token not in reset_tokens:
        raise HTTPException(status_code=400, detail="Invalid or expired token")

    # ---------- PASSWORD VALIDATION ----------
    if not new_password or new_password.strip() == "":
        raise HTTPException(status_code=400, detail="Password is required")
    
    if " " in new_password:
        raise HTTPException(status_code=400, detail="Password cannot contain spaces")
    
    # Require 8+ chars, uppercase, lowercase, number, special char
    pattern = r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$'
    if not re.match(pattern, new_password):
        raise HTTPException(
            status_code=400,
            detail="Password must be 8+ chars, include uppercase, lowercase, number & special char"
        )

    # ---------- UPDATE PASSWORD ----------
    email = reset_tokens[token]
    user = db.query(User).filter(User.email == email).first()
    if not user:
        raise HTTPException(status_code=404, detail="User not found")

    user.hashed_password = hash_password(new_password)
    db.commit()

    # delete token after use
    del reset_tokens[token]

    return {"message": "Password updated successfully"}
