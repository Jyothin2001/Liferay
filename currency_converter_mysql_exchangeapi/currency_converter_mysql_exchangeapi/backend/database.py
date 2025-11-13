from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base
import os
from dotenv import load_dotenv
from passlib.context import CryptContext
load_dotenv()

DATABASE_URL = os.getenv("DATABASE_URL", "mysql+pymysql://root:Xworkzodc%40123@localhost:3306/currencydb")

engine = create_engine(DATABASE_URL, pool_pre_ping=True, echo=False)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

def init_db():
    # import models so they are registered with Base
    from models import User, ConversionLog
    Base.metadata.create_all(bind=engine)



# pwd_ctx = CryptContext(schemes=["pbkdf2_sha256"], deprecated="auto")

# def init_db():
#     from models import User, ConversionLog

#     print("🔁 Dropping and recreating all tables...")
#     Base.metadata.drop_all(bind=engine)
#     Base.metadata.create_all(bind=engine)
#     print("✅ Tables created successfully!")

#     # Create default admin
#     db = SessionLocal()
#     admin_email = os.getenv("ADMIN_EMAIL", "admin@gmail.com")
#     admin_password = os.getenv("ADMIN_PASSWORD", "admin123")

#     if not db.query(User).filter_by(email=admin_email).first():
#         hashed_pw = pwd_ctx.hash(admin_password)
#         admin = User(email=admin_email, hashed_password=hashed_pw, is_admin=1)
#         db.add(admin)
#         db.commit()
#         print(f"✅ Default admin created: {admin_email}")
#     else:
#         print("ℹ️ Admin already exists.")
#     db.close()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()