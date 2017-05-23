/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.control;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.PagosServiceService;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ReferenciaFactura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.Pago;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.Resultado;
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
            ResultadoConsulta resultadoConsulta = pagosServiceService
                    .getPagosServicePort()
                    .cosultar(buildReferenciaFactura(consultarFacturaReq));
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

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq ejecutarPagoReq) {
        PagosServiceService pagosServiceService;
        try {
            pagosServiceService = new PagosServiceService(new URL(ConsultarFacturaService.WSDL_URI));
            Resultado resultado = pagosServiceService.getPagosServicePort()
                    .pagar(buildPago(ejecutarPagoReq));
            return buildConsultarFacturaResp(resultado, ejecutarPagoReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de factura con los datos endpoint: %s, factura: %s, mensaje: %s",
                    ConsultarFacturaService.WSDL_URI,
                    ejecutarPagoReq.getFactura().getIdFactura(),
                    ex.getMessage());
            Logger.getLogger(ConsultarFacturaServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
            consultarFacturaResp.setMensajeError(mensajeError);
            return consultarFacturaResp;
        }
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq ejecutarPagoReq) {
        PagosServiceService pagosServiceService;
        try {
            pagosServiceService = new PagosServiceService(new URL(ConsultarFacturaService.WSDL_URI));
            Resultado resultado = pagosServiceService.getPagosServicePort()
                    .compensar(buildPago(ejecutarPagoReq));
            return buildConsultarFacturaResp(resultado, ejecutarPagoReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de factura con los datos endpoint: %s, factura: %s, mensaje: %s",
                    ConsultarFacturaService.WSDL_URI,
                    ejecutarPagoReq.getFactura().getIdFactura(),
                    ex.getMessage());
            Logger.getLogger(ConsultarFacturaServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
            consultarFacturaResp.setMensajeError(mensajeError);
            return consultarFacturaResp;
        }
    }

    private ConsultarFacturaResp buildConsultarFacturaResp(Resultado resultado, EjecutarPagoReq ejecutarPagoReq) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setValorFactura(ejecutarPagoReq.getValor());
        consultarFacturaResp.setIdFactura(resultado.getReferenciaFactura().getReferenciaFactura());
        consultarFacturaResp.setMensajeError(resultado.getMensaje());
        return consultarFacturaResp;

    }

    private Pago buildPago(EjecutarPagoReq ejecutarPagoReq) {
        Pago pago = new Pago();
        pago.setReferenciaFactura(buildReferenciaFactura(ejecutarPagoReq.getFactura()));
        pago.setTotalPagar(ejecutarPagoReq.getValor());
        return pago;
    }

    private ReferenciaFactura buildReferenciaFactura(ConsultarFacturaReq consultarFacturaResp) {
        ReferenciaFactura referenciaFactura = new ReferenciaFactura();
        referenciaFactura.setReferenciaFactura(consultarFacturaResp.getIdFactura());
        return referenciaFactura;
    }

}
