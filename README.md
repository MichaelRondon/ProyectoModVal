# ProyectoModVal

Composición de servicios en Docker para la materia de Modela y validación de la Especialización en Arquitectura Empresarial de Software de la Universidad Javeriana.


Desarrolladores: 
  
	David Camacho	davidcinho89 
	Diego Sánchez	dmsanchezr79
	Felipe Grisales	
	Marcela Vaquiro	marcevaquiro
	Michael Rondón	MichaelRondon
  
<b>Patrones implementados:</b>

  - Inventario de dominio: Los servicios de pagos del banco están identificados y se registran en un servidor WSO2.
  - Normalización de servicios: Los servicios implementados se concibieron para que tuvieran responsabilidades independientes.
  - Abstracción de entidad: Por ejemplo se modela el <b><i>Servicio de Saldos</i></b> como una entidad que se compone de un conunto de cuentas asociadas a un identificador de usuario.
  - Centralización de esquemas: Los esquemas están centralizados en el docuemnto <b><i>schemas.xsd</i></b> y mediante la ejecución del script <b><i>crearEntidadesJaxb.bat</i></b> se generan las clases alli definidas. Además varios servicios comparten entidades definidas en este esquema, por ejempolo los servicios de <b><i>Consulta de Pagos</i></b> y del <b><i>Dispatcher</i></b> comparten el mismo esquema del contrato.
  - Contrato desacoplado y Centralización de contrato: Las implementaciones se realizarón sobre contratos definidos y abstractos.
  - Trasnformación de modelo de datos y Puente de protocolos: Esta transformación la realiza el servicio <b><i>Dispatcher</i></b>.
  - Enrutamiento intermedio: El enrutamiento es realizado por el servicio <b><i>Dispatcher</i></b>
  - Transacción Atómica: El servicio de <b><i>Ejecutar Pago</i></b> gestiona la transacción de pago invocando a otros servicios y gestionando las compensaciones.
  - Compensación de transacciones: Tanto los servicios externos consumidos por el servicio de  <i>Dispatcher</i> como la transacción de modificación de saldos del <b><i>Servicio de Saldos</i></b> implementan operaciones de compensación.

<b>Composiciones:</b>

Hay dos composiciones:

1. El servicio de <b><i>Consultar Pago</i></b> invoca al servicio de <b><i>Dispatcher</i></b> que a su vez invoca los servicios externos cumpliento el papel de despachador y transformador.
2. El servicio de <i>Ejecutar Pago</i> se compone de servicios implementando la siguiente lógica:
	2.1. Consulta que el convenio exista y los datos de la factura mediante el servicio <b><i>Consultar Pago</i></b>.
	2.2. Modifica el saldo en la cuenta mediante el <b><i>Servicio de Saldos</i></b>
	2.3. Ejecuta el pago mediante el servicio de <b><i>Dispatcher</i></b> que a su vez consume los servicios externos.
	2.4. Si hay time-out en la ejecución del pago (408 - Request Timeout) envia la compensación del pago  mediante el servicio de <b><i>Dispatcher</i></b>
	2.5. Si hay problemas en la respuesta de la ejecución del pago envía la compensación del saldo mediante el <b><i>Servicio de Saldos</i></b>
	

<b>Requisitos de ejecución:</b>

Para que funcione el servicio <b><i>Dispatcher</i></b> implementado es necesario ejecutar el archivo start.sh del proyecto:
https://github.com/germansua/UJaveriana-AES-ModVal/tree/master/Workshop1

Adicionalmente se debe ejecutar el proyecto: 
W1-REST-Service-SpringBoot

Los endpoit del servicio <b><i>Dispatcher</i></b> se pueden verificar en las clases:  

	- edu.puj.aes.modyval.dispatcher.service.control.ConsultarFacturaRestService 
	- edu.puj.aes.modyval.dispatcher.service.control.ConsultarFacturaService

