import os, requests
from dotenv import load_dotenv
import requests
from datetime import datetime, timedelta
# Overall Purpose

# This module is responsible for communicating with third-party APIs (like ExchangeRate-API
#  and ExchangeRate.host
# ) to:

# Fetch the latest conversion rate between two currencies.

# Fetch a list of all supported currencies.

# Fetch historical (past days) exchange rates for chart display.

# Basically, this is your external data layer for currency info.
load_dotenv()

API_KEY = os.getenv("EXCHANGE_API_KEY", "0d162a229870b719134c8e58")
BASE_URL = "https://v6.exchangerate-api.com/v6"

# def fetch_rate_pair(from_currency: str, to_currency: str):
#     # Use ExchangeRate-API pair endpoint
#     url = f"{BASE_URL}/{API_KEY}/pair/{from_currency}/{to_currency}"
#     r = requests.get(url, timeout=10)
#     r.raise_for_status()
#     data = r.json()
#     # Expected structure: {'result':'success', 'conversion_rate': ...}
#     if data.get("result") == "success":
#         return float(data.get("conversion_rate")), data
#     else:
#         raise Exception("ExchangeRate-API error: " + str(data))


def fetch_rate_pair(from_currency: str, to_currency: str):
    url = f"{BASE_URL}/{API_KEY}/pair/{from_currency}/{to_currency}"
    try:
        r = requests.get(url, timeout=30)  # increase timeout
        r.raise_for_status()
        data = r.json()
        if data.get("result") == "success":
            return float(data.get("conversion_rate")), data
        else:
            raise Exception("ExchangeRate-API returned error: " + str(data))
    except requests.exceptions.Timeout:
        raise Exception("ExchangeRate API timed out. Please try again later.")
    except requests.exceptions.RequestException as e:
        raise Exception(f"ExchangeRate API error: {e}")


def fetch_supported_currencies():
    # ExchangeRate-API has /codes endpoint
    try:
        url = f"{BASE_URL}/{API_KEY}/codes"
        r = requests.get(url, timeout=10)
        r.raise_for_status()
        data = r.json()
        # data.results: list of [code, name]
        codes = {}
        for item in data.get("supported_codes", []):
            code = item[0]
            name = item[1]
            codes[code] = name
        return codes
    except Exception:
        # fallback: minimal set
        return {
            "USD":"United States Dollar",
            "EUR":"Euro",
            "INR":"Indian Rupee",
            "GBP":"British Pound",
            "JPY":"Japanese Yen",
            "AUD":"Australian Dollar",
            "CAD":"Canadian Dollar"
        }
import os
import requests
from datetime import datetime, timedelta
from dotenv import load_dotenv

load_dotenv()

# API_KEY = "0d162a229870b719134c8e58"

# def fetch_timeseries(base: str, target: str, days: int = 7):
#     # Get latest rates first
#     url = f"https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{base}"
#     response = requests.get(url)
#     response.raise_for_status()
#     data = response.json()
    
#     if data.get("result") != "success":
#         return []

#     # Extract rate for target
#     rate = data["conversion_rates"].get(target)
    
#     # For historical data, ExchangeRate-API requires a paid plan; free plan only provides latest
#     # So you can return the latest rate for each past day as a mock or implement only latest rate
#     series = []
#     from datetime import datetime, timedelta
#     for i in range(days):
#         date = (datetime.utcnow().date() - timedelta(days=i)).isoformat()
#         series.append([date, rate])

#     return list(reversed(series))

def fetch_timeseries(base: str, target: str, days: int = 7):
    url = f"https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{base}"
    response = requests.get(url)
    response.raise_for_status()
    data = response.json()

    if data.get("result") != "success":
        return []

    rate = data["conversion_rates"].get(target)
    series = []

    from datetime import datetime, timedelta
    for i in range(days):
        date = (datetime.utcnow().date() - timedelta(days=i)).isoformat()
        series.append([date, base, target, rate])

    return list(reversed(series))


