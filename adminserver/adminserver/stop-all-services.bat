@echo off
REM stop-all-services.bat - interactive helper to stop services by port

:: List of ports used by your workspace services (adjust if needed)
set PORTS=8761 2024 2020 2021 2022 2023
necho ==================================================
echo Stop services helper - will check ports: %PORTS%
echo You will be prompted before any process is killed.
echo ==================================================
nfor %%P in (%PORTS%) do (
    echo.
    echo ---- Checking port %%P ----
    for /f "tokens=5" %%A in ('netstat -ano ^| findstr :%%P') do (
        set "PID=%%A"
        call :handlePid %%A %%P
    )
)
echo.
echo Done.
pause
exit /b
n:handlePid
REM %1 = PID, %2 = port
echo Found PID %1 listening on port %2
tasklist /FI "PID eq %1"
set /p ANS=Do you want to kill PID %1 ? (y/N): 
if /I "%ANS%"=="Y" (
    echo Killing PID %1 ...
    taskkill /PID %1 /F
    if %ERRORLEVEL%==0 (
        echo PID %1 killed successfully.
    ) else (
        echo Failed to kill PID %1. You may need elevated privileges.
    )
) else (
    echo Skipping PID %1
)
exit /b
