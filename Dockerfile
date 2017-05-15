FROM docker-local-2.homeawaycorp.com/ha-docker/minijava:1.8.0_112-master
COPY . /app
ENTRYPOINT ["./app/run_tests.sh"]
