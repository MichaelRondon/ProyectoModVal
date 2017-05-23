/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.ejecutar.pago.artifacts.control;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaReq;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaResp;
import javax.ejb.Local;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@Local
public interface ConsultarConvenioService {
    
    public static final String WSDL_URI = "http://consultar_pago_service:8080/consultar-pago-service/ConsultarConvenioService?wsdl";
    
    ConsultarFacturaResp consultar (ConsultarFacturaReq consultarFacturaReq);
    
}
