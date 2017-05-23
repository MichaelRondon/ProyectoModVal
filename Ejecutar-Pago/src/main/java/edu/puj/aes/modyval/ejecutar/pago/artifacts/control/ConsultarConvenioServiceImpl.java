package edu.puj.aes.modyval.ejecutar.pago.artifacts.control;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaReq;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarPagoInterface;
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
public class ConsultarConvenioServiceImpl implements ConsultarConvenioService {

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        try {
            edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarConvenioService consultarConvenioService
                    = new edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarConvenioService(new URL(ConsultarConvenioService.WSDL_URI));
            ConsultarPagoInterface consultarConvenioPort = consultarConvenioService.getConsultarConvenioPort();
            return consultarConvenioPort.consultar(consultarFacturaReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de convenios con los datos endpoint: %s, factura: %s, mensaje: %s",
                    ConsultarConvenioService.WSDL_URI,
                    consultarFacturaReq.getIdFactura(),
                    ex.getMessage());
            ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
            consultarFacturaResp.setMensajeError(mensajeError);
            consultarFacturaResp.setIdFactura(consultarFacturaReq.getIdFactura());
            Logger.getLogger(ConsultarConvenioServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            return consultarFacturaResp;
        }
    }

}
