from sqlalchemy.orm import Session
from models import ConversionLog, User
from auth import hash_password
import uuid

# -----------------------
# Conversion Logs
# -----------------------

def log_conversion(db: Session, user_id: int, from_currency: str, to_currency: str, amount: float, result: float, rate: float, raw: str):
    """
    Logs a currency conversion for a user.
    """
    entry = ConversionLog(
        user_id=user_id,
        from_currency=from_currency,
        to_currency=to_currency,
        amount=amount,
        result=result,
        rate=rate,
        raw_response=str(raw)
    )
    db.add(entry)
    db.commit()
    db.refresh(entry)
    return entry

def get_recent_conversions(db: Session, limit: int = 50):
    """
    Returns the most recent conversion logs.
    """
    return db.query(ConversionLog).order_by(ConversionLog.id.desc()).limit(limit).all()

def get_user_conversions(db: Session, user_id: int):
    """
    Returns all conversions for a specific user.
    """
    return db.query(ConversionLog).filter(ConversionLog.user_id == user_id).all()

# -----------------------
# User Operations
# -----------------------

def create_user(db: Session, email: str, password: str, is_admin: int = 0):
    """
    Creates a new user (normal or admin).
    """
    hashed_pw = hash_password(password)
    new_user = User(email=email, hashed_password=hashed_pw, is_admin=is_admin)
    db.add(new_user)
    db.commit()
    db.refresh(new_user)
    return new_user

def get_user_by_email(db: Session, email: str):
    """
    Retrieves a user by email.
    """
    return db.query(User).filter(User.email == email).first()

def get_user_by_id(db: Session, user_id: int):
    """
    Retrieves a user by ID.
    """
    return db.query(User).filter(User.id == user_id).first()


def set_reset_token(db: Session, email: str):
    user = db.query(User).filter(User.email == email).first()
    if not user:
        return None
    token = str(uuid.uuid4())
    user.reset_token = token
    db.commit()
    return token

def reset_password(db: Session, token: str, new_password: str):
    user = db.query(User).filter(User.reset_token == token).first()
    if not user:
        return False
    user.hashed_password = hash_password(new_password)  # ✅ must hash
    user.reset_token = None
    db.commit()
    return True


# def set_reset_token(db: Session, email: str):
#     """
#     Generates and sets a password reset token for a user.
#     """
#     token = str(uuid.uuid4())
#     user = get_user_by_email(db, email)

#     if not user:
#         return None

#     user.reset_token = token
#     db.commit()
#     return token

# def reset_password(db: Session, token: str, new_password: str):
#     """
#     Resets the user's password using the reset token.
#     """
#     user = db.query(User).filter(User.reset_token == token).first()

#     if not user:
#         return False

#     user.hashed_password = hash_password(new_password)
#     user.reset_token = None
#     db.commit()
#     return True



# from sqlalchemy.orm import Session
# from models import ConversionLog, User,Client
# from auth import hash_password
# import uuid

# # This file handles interaction with the database for conversion logs — basically, it keeps track of:

# # which currency was converted,

# # what amount,

# # the rate used,

# # the result,

# # and the raw API respons
# # def log_conversion(db: Session, from_currency, to_currency, amount, result, rate, raw):
# #     entry = ConversionLog(from_currency=from_currency, to_currency=to_currency, amount=amount, result=result, rate=rate, raw_response=str(raw))
# #     db.add(entry)
# #     db.commit()
# #     db.refresh(entry)
# #     return entry

# def log_conversion(db: Session, user_id, from_currency, to_currency, amount, result, rate, raw):
#     entry = ConversionLog(
#         user_id=user_id,
#         from_currency=from_currency,
#         to_currency=to_currency,
#         amount=amount,
#         result=result,
#         rate=rate,
#         raw_response=str(raw)
#     )
#     db.add(entry)
#     db.commit()
#     db.refresh(entry)
#     return entry


# def get_recent_conversions(db: Session, limit=50):
#     return db.query(ConversionLog).order_by(ConversionLog.id.desc()).limit(limit).all()



