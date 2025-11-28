from fastapi import FastAPI,Depends, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from dotenv import load_dotenv
import os
from routers import auth_router, convert_router, admin_router, misc_router,user_router
from pydantic import BaseModel
from sqlalchemy.orm import Session
from auth import create_default_admin
from database import init_db, get_db, engine, Base, SessionLocal
from fastapi_mail import FastMail, MessageSchema, ConnectionConfig
from pydantic import EmailStr
from routers import forgot_router



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
    "http://127.0.0.1:5173","http://192.168.0.102:5173","*"],  # tighten for production
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
app.include_router(forgot_router.router, prefix="/user", tags=["forgot-password"])








