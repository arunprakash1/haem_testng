#!/bin/sh

echo "Running TESTNG tests"
mvn surefire-report:report
