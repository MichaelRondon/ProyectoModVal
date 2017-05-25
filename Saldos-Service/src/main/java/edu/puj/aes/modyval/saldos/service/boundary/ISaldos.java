/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.saldos.service.boundary;

import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentaReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentasResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ModificarCuentaReq;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(name = "ISaldos", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ISaldos {

    @WebMethod(operationName = "Consultar", action = "consultar")
    @WebResult(name = "Respuesta1", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    ConsultarSaldoResp consultar(
        @WebParam(name = "Peticion1", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
            ConsultarSaldoReq input);

    @WebMethod(operationName = "ConsultarCuenta", action = "consultarCuenta")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    ConsultarCuentasResp consultarCuenta(
        @WebParam(name = "Peticion2", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
            ConsultarCuentaReq input);

    @WebMethod(operationName = "ModificarCuenta", action = "modificarCuenta")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    ConsultarCuentasResp modificarCuenta(
        @WebParam(name = "Peticion4", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
            ModificarCuentaReq input);
}
