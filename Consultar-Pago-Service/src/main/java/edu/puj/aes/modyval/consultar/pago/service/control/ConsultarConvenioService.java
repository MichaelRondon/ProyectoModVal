/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.consultar.pago.service.control;

import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaResp;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface ConsultarConvenioService {
    
    public static final String WSDL_URI = "http://dispatcher_service:8080/dispatcher-service/ConsultarFacturaService?wsdl";
    
    ConsultarFacturaResp consultar (ConsultarFacturaReq consultarFacturaReq);
    
}
