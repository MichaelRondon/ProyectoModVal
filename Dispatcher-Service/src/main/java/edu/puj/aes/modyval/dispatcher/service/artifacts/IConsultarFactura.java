package edu.puj.aes.modyval.dispatcher.service.artifacts;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author acost
 */
@WebService(name = "IConsultarFactura", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IConsultarFactura {
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Consultar", action = "consultar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
    public ConsultarFacturaResp consultar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
        ConsultarFacturaReq input);
    
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
    public ConsultarFacturaResp pagar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
        EjecutarPagoReq input);
    
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Compensar", action = "compensar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
    public ConsultarFacturaResp compensar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", partName = "Input")
        EjecutarPagoReq input);
    
}
