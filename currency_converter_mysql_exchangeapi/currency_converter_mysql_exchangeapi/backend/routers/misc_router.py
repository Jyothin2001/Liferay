from fastapi import APIRouter
from services.exchange_service import fetch_supported_currencies
router = APIRouter()

@router.get("/currencies")
def currencies():
    codes = fetch_supported_currencies()
    return {"success": True, "codes": codes}
