from pydantic import BaseModel, EmailStr
from typing import Optional, List
from datetime import datetime
from typing import List, Union

# Admin
class Token(BaseModel):
    access_token: str
    token_type: str = "bearer"

class AuthRequest(BaseModel):
    email: EmailStr
    password: str

class ConvertRequest(BaseModel):
    from_currency: str
    to_currency: str
    amount: float

class ConvertResponse(BaseModel):
    success: bool
    from_currency: str
    to_currency: str
    amount: float
    result: float
    rate: Optional[float] = None

class ConversionLogOut(BaseModel):
    id: int
    timestamp: datetime
    from_currency: str
    to_currency: str
    amount: float
    result: float
    rate: Optional[float]
    class Config:
        orm_mode = True

class HistoryOut(BaseModel):
    success: bool
    series: List[List[Union[str, float]]]
class Config:
        from_attributes = True  # for Pydantic V2, replaces orm_mode



        # User
class UserCreate(BaseModel):
    email: str
    password: str

class UserOut(BaseModel):
    id: int
    email: str

    model_config = {"from_attributes": True}

# Conversion
class ConversionCreate(BaseModel):
    from_currency: str
    to_currency: str
    amount: float

# class ConversionOut(BaseModel):
#     id: int
#     timestamp: datetime
#     from_currency: str
#     to_currency: str
#     amount: float
#     result: float
#     rate: float

#     model_config = {"from_attributes": True}  # for Pydantic V2

class ConversionOut(BaseModel):
    id: int
    timestamp: datetime
    from_currency: str
    to_currency: str
    amount: float
    result: float
    rate: Optional[float] = None   # ✅ FIXED

    model_config = {"from_attributes": True}


class ConvertRequest(BaseModel):
    from_currency: str
    to_currency: str
    amount: float


class ConvertResponse(BaseModel):
    from_currency: str
    to_currency: str
    amount: float
    result: float


class ForgotPasswordRequest(BaseModel):
    email: EmailStr

class ResetPasswordRequest(BaseModel):
    token: str
    new_password: str
