FROM docker-local-2.homeawaycorp.com/ha-docker/minijava:1.8.0_112-master
ENTRYPOINT ["./run_tests.sh"]
