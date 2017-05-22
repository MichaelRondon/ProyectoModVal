mvn clean package
docker build -t consultar-pago-service .
docker run -d -p 7073:8080 --name consultar-pago-service consultar-pago-service