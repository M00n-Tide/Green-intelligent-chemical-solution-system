@echo off
echo ===========================================
echo Green Intelligent Chemistry System - Database Switching Tool
echo ===========================================
echo.

echo Current database configuration:
if exist "src\main\resources\application.properties" (
    findstr /i "h2\|mysql\|postgresql" "src\main\resources\application.properties" | findstr /i "spring.datasource.url"
)

echo.
echo Please select the database type to switch to:
echo 1. H2 (Embedded database, default)
echo 2. MySQL
echo 3. PostgreSQL
echo 4. Exit
echo.

set /p choice=Please enter option (1-4): 

if "%choice%"=="1" (
    echo.
    echo Switching to H2 database...
    copy "src\main\resources\application-h2.properties" "src\main\resources\application.properties" >nul 2>&1
    echo Switching completed! H2 database requires no additional configuration.
    echo Data will be saved in the data folder under the project directory.
)
if "%choice%"=="2" (
    echo.
    echo Switching to MySQL database...
    copy "src\main\resources\application-mysql.properties" "src\main\resources\application.properties" >nul 2>&1
    echo Switching completed!
    echo.
    echo Important Notes:
    echo 1. Please ensure MySQL database is installed
    echo 2. Please create a database named lumap_db
    echo 3. Please modify database connection information in src\main\resources\application.properties
    echo 4. Please ensure pom.xml contains MySQL driver dependency
)
if "%choice%"=="3" (
    echo.
    echo Switching to PostgreSQL database...
    copy "src\main\resources\application-postgresql.properties" "src\main\resources\application.properties" >nul 2>&1
    echo Switching completed!
    echo.
    echo Important Notes:
    echo 1. Please ensure PostgreSQL database is installed
    echo 2. Please create a database named lumap_db
    echo 3. Please modify database connection information in src\main\resources\application.properties
    echo 4. Please ensure pom.xml contains PostgreSQL driver dependency
)
if "%choice%"=="4" (
    echo Exit
    exit /b 0
)

echo.
echo Please restart the application to apply the new database configuration
pause