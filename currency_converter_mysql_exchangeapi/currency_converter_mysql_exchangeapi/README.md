# Currency Converter (FastAPI + React) — MySQL + ExchangeRate-API

## What this package contains
- Backend (FastAPI) with MySQL (SQLAlchemy + pymysql)
  - Endpoints:
    - POST /convert/        → convert amount using ExchangeRate-API (pair endpoint)
    - GET  /currencies      → list supported currency codes (cached)
    - GET  /history?base=USD&target=INR&days=7 → history for chart (uses exchangerate.host free timeseries)
    - POST /auth/login      → admin login (JWT)
    - GET  /admin/conversions → admin-only conversion logs
- Frontend (React + Vite) 
  - Modern UI with converter, swap button, history chart (Chart.js), admin panel
- `.env.example` with defaults (change before production)
- Use the provided ExchangeRate-API key by default (you may change it in `.env`)

## Quick start (backend)
1. Create & activate a virtualenv:
   ```
   python -m venv venv
   source venv/bin/activate        # Windows: venv\Scripts\activate
   ```
2. Install backend deps:
   ```
   pip install fastapi uvicorn sqlalchemy pymysql pydantic python-dotenv passlib[bcrypt] pyjwt requests
   ```
3. Create MySQL database:
   ```sql
   CREATE DATABASE currencydb;
   ```
4. Copy `.env.example` to `.env` and update credentials if needed.
5. Run backend:
   ```
   cd backend
   uvicorn main:app --reload
   ```
6. Open API docs: http://localhost:8000/docs

## Quick start (frontend)
```
cd frontend
npm install
npm run dev
```
Open http://localhost:5173

## Notes
- Conversion rates use ExchangeRate-API pair endpoint with the provided key.
- Historical data for charts uses exchangerate.host (no API key required) to provide timeseries.
- This is a starter app — for production, secure your secrets, use HTTPS, and consider using a managed DB.
