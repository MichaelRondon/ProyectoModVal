/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.authentication.service.boundary;

import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationReq;
import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationResp;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author acost
 */
@WebService(name = "AuthenticationInterface", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AuthenticationInterface {
    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Autenticar", action = "autenticar")
    @WebResult(name = "Respuesta", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
    public AuthenticationResp autenticar(
        @WebParam(name = "Peticion", targetNamespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", partName = "Input")
        AuthenticationReq input);
}
