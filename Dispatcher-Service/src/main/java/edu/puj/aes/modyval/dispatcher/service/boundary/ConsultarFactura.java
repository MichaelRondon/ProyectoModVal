/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.boundary;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.dispatcher.service.control.ConsultarFacturaRestService;
import edu.puj.aes.modyval.dispatcher.service.control.ConsultarFacturaService;
import javax.ejb.EJB;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.dispatcher.service.boundary.IConsultarFactura")
public class ConsultarFactura implements IConsultarFactura {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarFactura.class);

    @EJB
    private ConsultarFacturaService consultarFactura;
    @EJB
    private ConsultarFacturaRestService consultarFacturaRestService;

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq input) {
        LOGGER.info("DispatcherService. Factura id: {}", input.getIdFactura());
        if (input.getIdFactura().startsWith("1")) {
            return consultarFacturaRestService.consultar(input);
        }
        return consultarFactura.consultar(input);
    }

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq input) {
        LOGGER.info("DispatcherService. Factura id: {}. Valor: {}",
                input.getFactura().getIdFactura(), input.getValor());
        if (input.getFactura().getIdFactura().startsWith("1")) {
            return consultarFacturaRestService.pagar(input);
        }
        return consultarFactura.pagar(input);
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq input) {
        LOGGER.info("DispatcherService: {}", input);
        if (input.getFactura().getIdFactura().startsWith("1")) {
            return consultarFacturaRestService.pagar(input);
        }
        return consultarFactura.pagar(input);
    }

}
