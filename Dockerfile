FROM maven:3-jdk-8
COPY . /app
ENTRYPOINT ["./app/run_tests.sh"]
