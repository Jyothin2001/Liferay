from sqlalchemy.orm import Session
from models import ConversionLog, User
# This file handles interaction with the database for conversion logs — basically, it keeps track of:

# which currency was converted,

# what amount,

# the rate used,

# the result,

# and the raw API respons
def log_conversion(db: Session, from_currency, to_currency, amount, result, rate, raw):
    entry = ConversionLog(from_currency=from_currency, to_currency=to_currency, amount=amount, result=result, rate=rate, raw_response=str(raw))
    db.add(entry)
    db.commit()
    db.refresh(entry)
    return entry

def get_recent_conversions(db: Session, limit=50):
    return db.query(ConversionLog).order_by(ConversionLog.id.desc()).limit(limit).all()
