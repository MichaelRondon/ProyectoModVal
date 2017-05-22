/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.consultar.pago.service.artifacts;

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
@WebService(name = "ConsultarPagoInterface", targetNamespace = "http://www.modval.aes.puj.edu.co/consulta/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IConsultarConvenios {
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
    
}
