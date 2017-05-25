/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.ejecutar.pago.control;

import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.EjecutarPagoReq;
import javax.ejb.Local;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@Local
public interface PagarFacturaService {
    
    public static final String WSDL_URI = "http://dispatcher_service:8080/dispatcher-service/ConsultarFacturaService?wsdl";
    
    ConsultarFacturaResp pagar(EjecutarPagoReq ejecutarPagoReq);
    ConsultarFacturaResp compensar(EjecutarPagoReq ejecutarPagoReq);
    
}
