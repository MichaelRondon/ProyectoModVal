mvn clean package
docker build -t authentication-service .
docker run -d -p 7071:8080 --name authentication-service authentication-service