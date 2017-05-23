/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.saldos.service.artifacts;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(name = "ISaldos", targetNamespace = "http://www.modval.aes.puj.edu.co/saldo/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ISaldos {

    @WebMethod(operationName = "Consultar", action = "consultar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", partName = "Input")
    ConsultarSaldoResp consultar(ConsultarSaldoReq input);

    @WebMethod(operationName = "ConsultarCuenta", action = "consultarCuenta")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", partName = "Input")
    ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq input);

    @WebMethod(operationName = "ModificarCuenta", action = "modificarCuenta")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", partName = "Input")
    ConsultarCuentasResp modificarCuenta(ModificarCuentaReq input);
}
