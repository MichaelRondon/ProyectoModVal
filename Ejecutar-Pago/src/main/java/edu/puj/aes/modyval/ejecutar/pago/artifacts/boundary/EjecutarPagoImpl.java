package edu.puj.aes.modyval.ejecutar.pago.artifacts.boundary;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPago;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaReq;
import javax.jws.WebService;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPago")
public class EjecutarPagoImpl implements EjecutarPago {

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ConsultarFacturaReq buildConsultaReq(EjecutarPagoReq ejecutarPagoReq) {
        ConsultarFacturaReq consultarFacturaReq = new ConsultarFacturaReq();
        consultarFacturaReq.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        return consultarFacturaReq;
    }

    private ConsultarFacturaResp buildConsultaResp(
            edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaResp consultarFacturaResp) {
        ConsultarFacturaResp consultarFacturaResp1 = new ConsultarFacturaResp();
        consultarFacturaResp1.setIdFactura(consultarFacturaResp.getIdFactura());
        consultarFacturaResp1.setMensajeError(consultarFacturaResp.getMensajeError());
        consultarFacturaResp1.setValorFactura(consultarFacturaResp.getValorFactura());
        return consultarFacturaResp1;
    }

    private edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.EjecutarPagoReq
            buildPagoReq(EjecutarPagoReq ejecutarPagoReq) {
        edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.EjecutarPagoReq ejecutarPagoReq1
                = new edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.EjecutarPagoReq();
        edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.ConsultarFacturaReq consultarFacturaReq1
                = new edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.ConsultarFacturaReq();
        consultarFacturaReq1.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        ejecutarPagoReq1.setFactura(consultarFacturaReq1);
        ejecutarPagoReq1.setValor(ejecutarPagoReq.getValor());
        return ejecutarPagoReq1;
    }

    private ConsultarFacturaResp buildPagoReq(
            edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.ConsultarFacturaResp consultarFacturaResp) {
        ConsultarFacturaResp consultarFacturaResp1 = new ConsultarFacturaResp();
        consultarFacturaResp1.setIdFactura(consultarFacturaResp.getIdFactura());
        consultarFacturaResp1.setMensajeError(consultarFacturaResp.getMensajeError());
        consultarFacturaResp1.setValorFactura(consultarFacturaResp.getValorFactura());
        return consultarFacturaResp1;
    }
}