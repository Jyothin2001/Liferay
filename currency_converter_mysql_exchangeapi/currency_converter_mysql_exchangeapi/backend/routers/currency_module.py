# currency_module.py
import requests
from datetime import datetime, timedelta

# ---------------- Latest conversion rate ----------------
def fetch_rate_pair(from_currency: str, to_currency: str):
    """
    Fetch latest conversion rate from `from_currency` to `to_currency`
    """
    url = f"https://api.exchangerate.host/convert?from={from_currency}&to={to_currency}"
    r = requests.get(url, timeout=20)
    r.raise_for_status()
    data = r.json()
    if data.get("success"):
        return float(data.get("result")), data
    else:
        raise Exception("ExchangeRate.host API error: " + str(data))

# ---------------- Historical timeseries ----------------
def fetch_timeseries(base: str, target: str, days: int = 7):
    """
    Fetch historical rates for the past `days` days.
    Returns list of [date, rate].
    """
    end = datetime.utcnow().date()
    start = end - timedelta(days=days - 1)  # include today

    url = (
        f"https://api.exchangerate.host/timeseries"
        f"?start_date={start}&end_date={end}"
        f"&base={base}&symbols={target}&places=6"
    )

    r = requests.get(url, timeout=20)
    r.raise_for_status()
    data = r.json()

    if not data.get("success"):
        return []

    series = []
    for date, values in sorted(data["rates"].items()):
        rate = values.get(target)
        if rate:
            series.append([date, float(rate)])
    return series

# ---------------- Supported currencies ----------------
def fetch_supported_currencies():
    """
    Return a dict of currency codes to names
    """
    try:
        url = "https://api.exchangerate.host/symbols"
        r = requests.get(url, timeout=20)
        r.raise_for_status()
        data = r.json()
        symbols = data.get("symbols", {})
        return {code: info["description"] for code, info in symbols.items()}
    except Exception:
        # fallback minimal set
        return {
            "USD": "United States Dollar",
            "EUR": "Euro",
            "INR": "Indian Rupee",
            "GBP": "British Pound",
            "JPY": "Japanese Yen",
            "AUD": "Australian Dollar",
            "CAD": "Canadian Dollar"
        }
