rmdir /s .\Authentication-Service\src\main\java\edu\puj\aes\modyval\authentication\service\artifacts
rmdir /s .\Consultar-Pago-Service\src\main\java\edu\puj\aes\modyval\consultar\pago\service\artifacts
rmdir /s .\Dispatcher-Service\src\main\java\edu\puj\aes\modyval\dispatcher\service\artifacts
rmdir /s .\Ejecutar-Pago\src\main\java\edu\puj\aes\modyval\ejecutar\pago\artifacts
rmdir /s .\Saldos-Service\src\main\java\edu\puj\aes\modyval\saldos\service\artifacts
xjc schema.xsd -d .\Authentication-Service\src\main\java -p edu.puj.aes.modyval.authentication.service.artifacts
xjc schema.xsd -d .\Consultar-Pago-Service\src\main\java -p edu.puj.aes.modyval.consultar.pago.service.artifacts
xjc schema.xsd -d .\Dispatcher-Service\src\main\java -p edu.puj.aes.modyval.dispatcher.service.artifacts
xjc schema.xsd -d .\Ejecutar-Pago\src\main\java -p edu.puj.aes.modyval.ejecutar.pago.artifacts
xjc schema.xsd -d .\Saldos-Service\src\main\java -p edu.puj.aes.modyval.saldos.service.artifacts
pause