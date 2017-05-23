/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.control;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.rest.Factura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.rest.Resultado;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface ConsultarFacturaRestService {
    public static final String ENDPOINT_URL = "http://192.168.99.100:9898/servicios/pagos/v1/payments/";
    
    ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq);
    
    Resultado pagar(String idFactura, double valorFactura);
    
    Resultado compensar(String idFactura);
}
