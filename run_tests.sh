#!/bin/sh

echo "Running TESTNG tests"
mvn -q surefire-report:report
