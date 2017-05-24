/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.consultar.pago.service.control;

import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.wsdl.ConsultarFacturaService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@Stateless
public class ConsultarConvenioServiceImpl implements ConsultarConvenioService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConsultarConvenioServiceImpl.class);

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        try {
            ConsultarFacturaService consultarFacturaService = new ConsultarFacturaService(new URL(ConsultarConvenioService.WSDL_URI));
            edu.puj.aes.modyval.consultar.pago.service.artifacts.wsdl.ConsultarFacturaReq consultarFacturaReq1
                    = new edu.puj.aes.modyval.consultar.pago.service.artifacts.wsdl.ConsultarFacturaReq();
            consultarFacturaReq1.setIdFactura(consultarFacturaReq.getIdFactura());
            edu.puj.aes.modyval.consultar.pago.service.artifacts.wsdl.ConsultarFacturaResp consultar = consultarFacturaService.getConsultarFacturaPort().consultar(consultarFacturaReq1);

            LOGGER.info("Respuesta consulta convenio. Factura Id: {}. Valor: {}. Mensaje de error: {}",
                    consultarFacturaReq.getIdFactura(), consultar.getValorFactura(),
                    consultar.getMensajeError());

            consultarFacturaResp.setIdFactura(consultarFacturaReq.getIdFactura());
            consultarFacturaResp.setValorFactura(consultar.getValorFactura());
            consultarFacturaResp.setMensajeError(consultar.getMensajeError());
            return consultarFacturaResp;
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de factura con los datos endpoint: %s, factura: %s, mensaje: %s",
                    ConsultarConvenioService.WSDL_URI,
                    consultarFacturaReq.getIdFactura(),
                    ex.getMessage());
            Logger.getLogger(ConsultarConvenioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            consultarFacturaResp.setMensajeError(mensajeError);
            return consultarFacturaResp;
        }

    }

}
