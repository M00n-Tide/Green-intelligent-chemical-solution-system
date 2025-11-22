@echo off
echo ===========================================
echo Green Intelligent Chemistry System Startup Script
echo ===========================================
echo.

echo Checking Java environment...
java -version
if %errorlevel% neq 0 (
    echo Error: Java environment not found, please install Java 11 or higher
    pause
    exit /b 1
)

echo.
echo Checking Maven environment...
mvn -version
if %errorlevel% neq 0 (
    echo Error: Maven environment not found, please install Apache Maven
    pause
    exit /b 1
)

echo.
echo Compiling and starting application...
mvn clean spring-boot:run

if %errorlevel% neq 0 (
    echo Error: Application startup failed
    pause
    exit /b 1
)

pause