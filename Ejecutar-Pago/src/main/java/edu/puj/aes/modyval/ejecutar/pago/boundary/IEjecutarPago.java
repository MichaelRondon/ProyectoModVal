/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.ejecutar.pago.boundary;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPagoReq;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(name = "EjecutarPago", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IEjecutarPago {
    
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    public ConsultarFacturaResp pagar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
        EjecutarPagoReq input);
    
//    @WebMethod(operationName = "Compensar", action = "compensar")
//    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
//    public ConsultarFacturaResp compensar(
//        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
//        EjecutarPagoReq input);
}