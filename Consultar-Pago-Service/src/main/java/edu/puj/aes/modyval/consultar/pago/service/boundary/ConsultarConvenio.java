/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.consultar.pago.service.boundary;

import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.IConsultarConvenios;
import edu.puj.aes.modyval.consultar.pago.service.control.ConsultarConvenioService;
import javax.ejb.EJB;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.consultar.pago.service.artifacts.IConsultarConvenios")
public class ConsultarConvenio implements IConsultarConvenios {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarConvenio.class);
    
    @EJB
    private ConsultarConvenioService consultarConvenioService;
    
    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq input) {
        LOGGER.info("ConsultarPagoService. Factura id: {}", input.getIdFactura());
        return consultarConvenioService.consultar(input);
    }
    
}
