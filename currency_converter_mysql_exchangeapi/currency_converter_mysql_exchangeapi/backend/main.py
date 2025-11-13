from fastapi import FastAPI,Depends, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from dotenv import load_dotenv
import os
from routers import auth_router, convert_router, admin_router, misc_router,user_router
from pydantic import BaseModel
from sqlalchemy.orm import Session
from auth import create_default_admin
from database import init_db, get_db, engine, Base, SessionLocal



# Explanation:

# FastAPI → Creates the main web application.

# CORSMiddleware → Allows frontend (like React) to talk to backend (FastAPI) running on different ports.

# load_dotenv() → Loads variables from a .env file into your environment (for secrets like DB credentials, API keys, etc.).

# routers → These are separate files where your API routes (endpoints) are organized:

# auth_router → Login, register, JWT token-related routes.

# convert_router → Currency conversion endpoints.

# admin_router → Admin-only endpoints.

# misc_router → Other small utility endpoints.

# database imports → For initializing the database and managing sessions.

# What this does:

# CORS (Cross-Origin Resource Sharing) lets your frontend (React app on http://localhost:5173) make requests to your backend (FastAPI, probably running on http://localhost:8000).

# allow_origins → which domains can send requests.

# allow_credentials=True → allows cookies or tokens in headers.

# allow_methods=["*"] → all HTTP methods (GET, POST, PUT, DELETE, etc.) are allowed.

# allow_headers=["*"] → all headers are accepted.

# Without this, you’d get a CORS error in the browser.

load_dotenv()

app = FastAPI(title="Currency Converter API")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173",   # React dev server
    "http://127.0.0.1:5173","http://localhost:5174",     # ✅ add this
        "http://127.0.0.1:5174"],  # tighten for production
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.on_event("startup")
def startup():
    # init_db() → usually calls code to create tables or connect to the database using SQLAlchemy.
    print("🌟 Startup event triggered")
    init_db() 
    # Auto-generate admin
    db = SessionLocal()
    try:
        create_default_admin(db)
        print("🚀 Server started, admin checked/created successfully")
    finally:
        db.close()

    # Root endpoint
@app.get("/")
def home():
    return {"message": "Welcome to currency converter!"}

app.include_router(auth_router.router, prefix="/auth", tags=["auth"])
app.include_router(convert_router.router, prefix="/convert", tags=["convert"])
app.include_router(admin_router.router, prefix="/admin", tags=["admin"])
app.include_router(misc_router.router, prefix="", tags=["misc"])
app.include_router(user_router.router, prefix="/user", tags=["user"])





# # user
# Base.metadata.create_all(bind=engine)

# app = FastAPI()
# oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")

# EXCHANGE_API_KEY = "0d162a229870b719134c8e58"

# # -------------------------
# # User Registration
# # -------------------------
# @app.post("/register", response_model=UserOut)
# def register(user: UserCreate, db: Session = Depends(get_db)):
#     db_user = db.query(User).filter(User.email == user.email).first()
#     if db_user:
#         raise HTTPException(status_code=400, detail="Email already registered")
#     new_user = User(email=user.email, hashed_password=hash_password(user.password))
#     db.add(new_user)
#     db.commit()
#     db.refresh(new_user)
#     return new_user

# # -------------------------
# # User Login
# # -------------------------
# @app.post("/login")
# def login(user: UserCreate, db: Session = Depends(get_db)):
#     db_user = db.query(User).filter(User.email == user.email).first()
#     if not db_user or not verify_password(user.password, db_user.hashed_password):
#         raise HTTPException(status_code=401, detail="Invalid credentials")
#     token = create_access_token({"user_id": db_user.id})
#     return {"access_token": token, "token_type": "bearer"}

# # -------------------------
# # Get Current User
# # -------------------------
# def get_current_user(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)):
#     payload = decode_access_token(token)
#     user = db.query(User).filter(User.id == payload.get("user_id")).first()
#     if not user:
#         raise HTTPException(status_code=401, detail="User not found")
#     return user


# # -------------------------
# # Convert Currency
# # -------------------------
# @app.post("/convert", response_model=ConversionOut)
# def convert(data: ConversionCreate, db: Session = Depends(get_db), user: User = Depends(get_current_user)):
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

# # -------------------------
# # User Conversion History
# # -------------------------
# @app.get("/conversions", response_model=list[ConversionOut])
# def conversions(db: Session = Depends(get_db), user: User = Depends(get_current_user)):
#     return db.query(ConversionLog).filter(ConversionLog.user_id == user.id).order_by(ConversionLog.id.desc()).all()


