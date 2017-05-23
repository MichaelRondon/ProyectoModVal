mvn clean package
docker build -t ejecutar-pago-service .
docker run -d -p 7075:8080 --name ejecutar-pago-service ejecutar-pago-service