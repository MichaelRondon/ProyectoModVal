package edu.puj.aes.modyval.dispatcher.service.boundary;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.EjecutarPagoReq;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author acost
 */
@WebService(name = "IConsultarFactura", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IConsultarFactura {
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Consultar", action = "consultar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    public ConsultarFacturaResp consultar(
        @WebParam(name = "Peticion1", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
        ConsultarFacturaReq input);
    
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    public ConsultarFacturaResp pagar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
        EjecutarPagoReq input);
    
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Compensar", action = "compensar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    public ConsultarFacturaResp compensar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
        EjecutarPagoReq input);
    
}
