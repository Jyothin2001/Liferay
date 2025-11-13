from sqlalchemy import Column, Integer, String, Float, DateTime, Text,ForeignKey
from sqlalchemy.sql import func
from database import Base

from sqlalchemy.orm import relationship

# # Admin Loggin
# class User(Base):
#     __tablename__ = "users"
#     id = Column(Integer, primary_key=True, index=True)
#     email = Column(String(255), unique=True, index=True, nullable=False)
#     hashed_password = Column(String(255), nullable=False)
#     is_admin = Column(Integer, default=0)

# class ConversionLog(Base):
#     __tablename__ = "conversion_logs"
#     id = Column(Integer, primary_key=True, index=True)
#     timestamp = Column(DateTime(timezone=True), server_default=func.now())
#     from_currency = Column(String(10), nullable=False)
#     to_currency = Column(String(10), nullable=False)
#     amount = Column(Float, nullable=False)
#     result = Column(Float, nullable=False)
#     rate = Column(Float)
#     raw_response = Column(Text)

class User(Base):
    __tablename__ = "users"  # single table for both admin and normal users
    id = Column(Integer, primary_key=True, index=True)
    email = Column(String(255), unique=True, index=True, nullable=False)
    hashed_password = Column(String(255), nullable=False)
    is_admin = Column(Integer, default=0)  # 0 = normal user, 1 = admin

    conversions = relationship("ConversionLog", back_populates="user")

class ConversionLog(Base):
    __tablename__ = "conversion_logs"
    id = Column(Integer, primary_key=True, index=True)
    user_id = Column(Integer, ForeignKey("users.id"))
    timestamp = Column(DateTime(timezone=True), server_default=func.now())
    from_currency = Column(String(10), nullable=False)
    to_currency = Column(String(10), nullable=False)
    amount = Column(Float, nullable=False)
    result = Column(Float, nullable=False)
    rate = Column(Float)
    raw_response = Column(Text)

    user = relationship("User", back_populates="conversions")