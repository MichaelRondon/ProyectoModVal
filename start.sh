cd Authentication-Service
mvn clean package
cd ../Dispatcher-Service
mvn clean package
cd ../Consultar-Pago-Service
mvn clean package
cd ../Saldos-Service
mvn clean package
cd ../Ejecutar-Pago
mvn clean package
cd ..
docker-compose up -d --build