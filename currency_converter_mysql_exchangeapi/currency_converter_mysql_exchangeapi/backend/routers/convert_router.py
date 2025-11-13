from fastapi import APIRouter, HTTPException, Depends
from schemas import ConvertRequest, ConvertResponse
from services.exchange_service import fetch_rate_pair, fetch_timeseries
from auth import get_db
from crud import log_conversion

router = APIRouter()

@router.post("/", response_model=ConvertResponse)
def convert(req: ConvertRequest, db=Depends(get_db)):
    try:
        frm = req.from_currency.upper()
        to = req.to_currency.upper()
        rate, raw = fetch_rate_pair(frm, to)
        if rate is None:
            raise Exception("Rate not found")
        result = round(req.amount * float(rate), 6)
        try:
            log_conversion(db, frm, to, req.amount, result, float(rate), raw)
        except Exception:
            pass
        return {
            "success": True,
            "from_currency": frm,
            "to_currency": to,
            "amount": req.amount,
            "result": result,
            "rate": float(rate)
        }
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.get("/history")
def history(base: str = "USD", target: str = "INR", days: int = 7):
    try:
        series = fetch_timeseries(base.upper(), target.upper(), days)
        return {"success": True, "series": series}
    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))



