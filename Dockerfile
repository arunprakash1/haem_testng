FROM maven:3-jdk-8
COPY . /app
WORKDIR /app
ENTRYPOINT ["./run_tests.sh"]
