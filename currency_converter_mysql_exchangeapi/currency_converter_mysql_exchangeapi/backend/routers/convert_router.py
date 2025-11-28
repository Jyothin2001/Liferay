from fastapi import APIRouter, HTTPException, Depends
from schemas import ConvertRequest, ConvertResponse
from services.exchange_service import fetch_rate_pair, fetch_timeseries
from auth import get_db
from crud import log_conversion
from datetime import date, timedelta
from models import ConversionLog

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

# @router.get("/history")
# def history(base: str = "USD", target: str = "INR", days: int = 7):
#     try:
#         series = fetch_timeseries(base.upper(), target.upper(), days)
#         return {"success": True, "series": series}
#     except Exception as e:
#         raise HTTPException(status_code=400, detail=str(e))


from fastapi import APIRouter, HTTPException, Depends
from datetime import date, timedelta
from crud import ConversionLog
from sqlalchemy.orm import Session


router = APIRouter()

@router.get("/history")
def history(base: str, target: str, days: int = 7, db: Session = Depends(get_db)):
    from datetime import date, timedelta

    try:
        # CASE 1: Same currency selected
        if base == target:
            return {
                "success": True,
                "series": [],
                "message": "Same currency selected — conversion rate is always 1. No history required."
            }

        end = date.today()
        start = end - timedelta(days=days - 1)

        # Fetch all logs in the date range for this currency pair (all users)
        logs = (
            db.query(ConversionLog)
            .filter(
                ConversionLog.from_currency == base,
                ConversionLog.to_currency == target,
                ConversionLog.timestamp >= start,
                ConversionLog.timestamp <= end,
            )
            .order_by(ConversionLog.timestamp)
            .all()
        )

        # CASE 2: No logs at all for this currency pair
        if not logs:
            return {
                "success": True,
                "series": [],
                "message": "No history found for this currency pair. Chart will update after first conversion."
            }

        # Highest rate per day from all users
        day_rates = {}
        for log in logs:
            d = log.timestamp.date().isoformat()
            if d not in day_rates or log.rate > day_rates[d]:
                day_rates[d] = log.rate

        # Build series for full date range
        series = []
        for i in range(days):
            d = (start + timedelta(days=i)).isoformat()
            rate = float(day_rates[d]) if d in day_rates else None
            series.append([d, rate])

        # Message for frontend
        if end.isoformat() in day_rates:
            msg = "Showing latest conversion history including today's rate."
        else:
            msg = ""

        return {"success": True, "series": series, "message": msg}

    except Exception as e:
        raise HTTPException(status_code=400, detail=str(e))



