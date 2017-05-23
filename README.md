# ProyectoModVal

Composición de servicios en Docker para la materia de Modela y validación de la Especialización en Arquitectura Empresarial de Software de la Universidad Javeriana.


Desarrolladores: 
  
	David Camacho
	Diego Sánchez
	Felipe Grisales
	Marcela Vaquiro
	Michael Rondón
  
<b>Patrones implementados:</b>

  - Normalización de servicios: Los servicios implementados se concibieron para que tuvieran responsabilidades independientes.
  - Abstracción de entidad: Por ejemplo se modela el <i>Servicio de Saldos</i> como una entidad que se compone de un conunto de cuentas asociadas a un identificador de usuario.
  - Centralización de esquemas: Los servicios de <i>Consulta de Pagos</i> y del <i>Dispatcher</i> comparten el mismo esquema del contrato.
  - Contrato desacoplado y Centralización de contrato: Las implementaciones se realizarón sobre contratos definidos y abstractos.
  - Trasnformación de modelo de datos y Puente de protocolos: Esta transformación la realiza el servicio <i>Dispatcher</i>.
  - Enrutamiento intermedio: El enrutamiento es realizado por el servicio <i>Dispatcher</i>


