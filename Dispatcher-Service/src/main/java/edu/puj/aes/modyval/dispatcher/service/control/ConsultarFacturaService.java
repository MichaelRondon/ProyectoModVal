/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.control;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface ConsultarFacturaService {
    
    public static final String WSDL_URI = "http://localhost:7070/w1-soap-svr/PagosServiceService";
    
    ConsultarFacturaResp consultar(ConsultarFacturaReq authenticationReq);
}
