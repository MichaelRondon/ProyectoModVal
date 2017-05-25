package edu.puj.aes.modyval.ejecutar.pago.control;

import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.ConsultarFacturaService;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.EjecutarPagoReq;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.IConsultarFactura;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@Stateless
public class PagarFacturaServiceImpl implements PagarFacturaService {

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq ejecutarPagoReq) {
        try {
            return getPort().pagar(ejecutarPagoReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando el pago con el endpoint: %s, factura: %s, mensaje: %s",
                    PagarFacturaService.WSDL_URI,
                    ejecutarPagoReq.getFactura().getIdFactura(),
                    ex.getMessage());
            return buildErrorResponse(mensajeError, ejecutarPagoReq, ex);
        }
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq ejecutarPagoReq) {
        try {
            return getPort().compensar(ejecutarPagoReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la compensación con el endpoint: %s, factura: %s, mensaje: %s",
                    PagarFacturaService.WSDL_URI,
                    ejecutarPagoReq.getFactura().getIdFactura(),
                    ex.getMessage());
            return buildErrorResponse(mensajeError, ejecutarPagoReq, ex);
        }
    }

    private ConsultarFacturaResp buildErrorResponse(String mensajeError, EjecutarPagoReq ejecutarPagoReq, Exception ex) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setMensajeError(mensajeError);
        consultarFacturaResp.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        Logger.getLogger(ConsultarConvenioServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
        return consultarFacturaResp;

    }

    private IConsultarFactura getPort() throws MalformedURLException {
        ConsultarFacturaService consultarFacturaService
                = new ConsultarFacturaService(new URL(PagarFacturaService.WSDL_URI));
        return consultarFacturaService.getConsultarFacturaPort();
    }
}
