mvn clean package
docker build -t saldos-service .
docker run -d -p 7074:8080 --name saldos-service saldos-service