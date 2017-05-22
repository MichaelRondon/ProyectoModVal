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
import edu.puj.aes.modyval.dispatcher.service.exception.ConsultarFacturaException;
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

    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        PagosServiceService pagosServiceService;
        try {
            pagosServiceService = new PagosServiceService(new URL(ConsultarFacturaService.WSDL_URI));
            ReferenciaFactura referenciaFactura = new ReferenciaFactura();
            referenciaFactura.setReferenciaFactura(consultarFacturaReq.getIdFactura());
            ResultadoConsulta resultadoConsulta = pagosServiceService.getPagosServicePort().cosultar(referenciaFactura);
            System.out.println("cosultar: " + resultadoConsulta.getTotalPagar());
            ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
            consultarFacturaResp.setValorFactura(resultadoConsulta.getTotalPagar());
            consultarFacturaResp.setIdFactura(resultadoConsulta.getReferenciaFactura().getReferenciaFactura());
            return consultarFacturaResp;
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConsultarFacturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConsultarFacturaException(
                    String.format("Error realizando la consulta de factura con los datos endpoint: %s, factura: %s",
                            ConsultarFacturaService.WSDL_URI,
                            consultarFacturaReq.getIdFactura()),
                     ex);
        }
    }

}
