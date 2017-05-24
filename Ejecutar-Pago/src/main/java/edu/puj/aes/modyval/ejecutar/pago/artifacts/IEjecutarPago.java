package edu.puj.aes.modyval.ejecutar.pago.artifacts;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(name = "EjecutarPago", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IEjecutarPago {
    
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
    public ConsultarFacturaResp pagar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
        EjecutarPagoReq input);
    
//    @WebMethod(operationName = "Compensar", action = "compensar")
//    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
//    public ConsultarFacturaResp compensar(
//        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
//        EjecutarPagoReq input);
}
