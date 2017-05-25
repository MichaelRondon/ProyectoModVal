# ProyectoModVal

Composición de servicios en Docker para la materia de Modela y validación de la Especialización en Arquitectura Empresarial de Software de la Universidad Javeriana.


Desarrolladores: 
  
	David Camacho
	Diego Sánchez
	Felipe Grisales
	Marcela Vaquiro
	Michael Rondón
  
<b>Patrones implementados:</b>

  - Inventario de dominio: Los servicios de pagos del banco están identificados y se registran en un servidor WSO2.
  - Normalización de servicios: Los servicios implementados se concibieron para que tuvieran responsabilidades independientes.
  - Abstracción de entidad: Por ejemplo se modela el <i>Servicio de Saldos</i> como una entidad que se compone de un conunto de cuentas asociadas a un identificador de usuario.
  - Centralización de esquemas: Los esquemas están centralizados en el docuemnto <i>schemas.xsd</i> y mediante la ejecución del script <i>crearEntidadesJaxb.bat</i> se generan las clases alli definidas. Además varios servicios comparten entidades definidas en este esquema, por ejempolo los servicios de <i>Consulta de Pagos</i> y del <i>Dispatcher</i> comparten el mismo esquema del contrato.
  - Contrato desacoplado y Centralización de contrato: Las implementaciones se realizarón sobre contratos definidos y abstractos.
  - Trasnformación de modelo de datos y Puente de protocolos: Esta transformación la realiza el servicio <i>Dispatcher</i>.
  - Enrutamiento intermedio: El enrutamiento es realizado por el servicio <i>Dispatcher</i>
  - Transacción Atómica: El servicio de <i>Ejecutar Pago</i> gestiona la transacción de pago invocando a otros servicios y gestionando las compensaciones.
  - Compensación de transacciones: Tanto los servicios externos consumidos por el servicio de  <i>Dispatcher</i> como la transacción de modificación de saldos del <i>Servicio de Saldos</i> implementan operaciones de compensación.


