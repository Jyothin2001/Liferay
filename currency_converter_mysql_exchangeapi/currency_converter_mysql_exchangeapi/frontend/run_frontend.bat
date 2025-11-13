@echo off
title ⚛️ Starting React Frontend
cd /d "%~dp0"

echo 🔹 Installing npm packages (if needed)...
npm install >nul 2>&1

echo 🔹 Starting React app (Vite)...
npm run dev

pause
