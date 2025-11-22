#!/bin/bash

echo "==========================================="
echo "Green Intelligent Chemistry System Startup Script"
echo "==========================================="
echo

echo "Checking Java environment..."
if command -v java &> /dev/null; then
    java -version
else
    echo "Error: Java environment not found, please install Java 11 or higher"
    exit 1
fi

echo
echo "Checking Maven environment..."
if command -v mvn &> /dev/null; then
    mvn -version
else
    echo "Error: Maven environment not found, please install Apache Maven"
    exit 1
fi

echo
echo "Compiling and starting application..."
mvn clean spring-boot:run

if [ $? -ne 0 ]; then
    echo "Error: Application startup failed"
    exit 1
fi