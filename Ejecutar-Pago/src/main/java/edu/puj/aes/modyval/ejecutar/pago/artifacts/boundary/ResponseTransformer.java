package edu.puj.aes.modyval.ejecutar.pago.artifacts.boundary;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPagoReq;
import lombok.Getter;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class ResponseTransformer {

    @Getter
    private final ConsultarFacturaResp consultarFacturaResp;

    public ResponseTransformer(edu.puj.aes.modyval.ejecutar.pago.artifacts.consulta.wsdl.ConsultarFacturaResp consultarFacturaResp) {
        ConsultarFacturaResp consultarFacturaResp1 = new ConsultarFacturaResp();
        consultarFacturaResp1.setIdFactura(consultarFacturaResp.getIdFactura());
        consultarFacturaResp1.setMensajeError(consultarFacturaResp.getMensajeError());
        consultarFacturaResp1.setValorFactura(consultarFacturaResp.getValorFactura());
        this.consultarFacturaResp = consultarFacturaResp1;
    }

    public ResponseTransformer(edu.puj.aes.modyval.ejecutar.pago.artifacts.dispatcher.wsdl.ConsultarFacturaResp consultarFacturaResp) {
        ConsultarFacturaResp consultarFacturaResp1 = new ConsultarFacturaResp();
        consultarFacturaResp1.setIdFactura(consultarFacturaResp.getIdFactura());
        consultarFacturaResp1.setMensajeError(consultarFacturaResp.getMensajeError());
        consultarFacturaResp1.setValorFactura(consultarFacturaResp.getValorFactura());
        this.consultarFacturaResp = consultarFacturaResp1;
    }
                               
    public ResponseTransformer(edu.puj.aes.modyval.ejecutar.pago.artifacts.saldos.wsdl.ConsultarCuentasResp consultarCuentasResp,
            EjecutarPagoReq ejecutarPagoReq) {
        ConsultarFacturaResp consultarFacturaResp1 = new ConsultarFacturaResp();
        consultarFacturaResp1.setMensajeError(consultarCuentasResp.getMensajeError());
        consultarFacturaResp1.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        consultarFacturaResp1.setValorFactura(ejecutarPagoReq.getValor());
        this.consultarFacturaResp = consultarFacturaResp1;
    }
}
