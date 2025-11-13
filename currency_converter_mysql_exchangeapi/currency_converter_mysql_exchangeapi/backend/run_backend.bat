@echo off
title 🚀 Starting FastAPI Backend Server
cd /d "%~dp0"

echo 🔹 Activating virtual environment...
call venv\Scripts\activate

echo 🔹 Installing dependencies (if needed)...
pip install -r requirements.txt >nul 2>&1

echo 🔹 Starting FastAPI server...
uvicorn main:app --reload

pause
