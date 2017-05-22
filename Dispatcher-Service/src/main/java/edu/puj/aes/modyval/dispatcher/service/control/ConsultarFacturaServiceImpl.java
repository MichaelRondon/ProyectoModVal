/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.control;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.PagosServiceService;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ReferenciaFactura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ResultadoConsulta;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author acost
 */
@Stateless
public class ConsultarFacturaServiceImpl implements ConsultarFacturaService {

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        PagosServiceService pagosServiceService;
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        try {
            pagosServiceService = new PagosServiceService(new URL(ConsultarFacturaService.WSDL_URI));
            ReferenciaFactura referenciaFactura = new ReferenciaFactura();
            referenciaFactura.setReferenciaFactura(consultarFacturaReq.getIdFactura());
            ResultadoConsulta resultadoConsulta = pagosServiceService.getPagosServicePort().cosultar(referenciaFactura);
            System.out.println("cosultar: " + resultadoConsulta.getTotalPagar());
            consultarFacturaResp.setValorFactura(resultadoConsulta.getTotalPagar());
            consultarFacturaResp.setIdFactura(resultadoConsulta.getReferenciaFactura().getReferenciaFactura());
            return consultarFacturaResp;
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de factura con los datos endpoint: %s, factura: %s, mensaje: %s",
                    ConsultarFacturaService.WSDL_URI,
                    consultarFacturaReq.getIdFactura(),
                    ex.getMessage());
            Logger.getLogger(ConsultarFacturaServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            consultarFacturaResp.setMensajeError(mensajeError);
            return consultarFacturaResp;
        }
    }

}
