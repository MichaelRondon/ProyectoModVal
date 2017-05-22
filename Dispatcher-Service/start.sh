mvn clean package
docker build -t dispatcher-service .
docker run -d -p 7072:8080 --name dispatcher-service dispatcher-service