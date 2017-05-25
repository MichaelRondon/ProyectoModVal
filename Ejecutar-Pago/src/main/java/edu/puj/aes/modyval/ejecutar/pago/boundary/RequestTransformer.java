package edu.puj.aes.modyval.ejecutar.pago.boundary;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.consulta.wsdl.ConsultarFacturaReq;
import lombok.Getter;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class RequestTransformer {

    @Getter
    private final EjecutarPagoReq ejecutarPagoReq;

    public RequestTransformer(EjecutarPagoReq ejecutarPagoReq) {
        this.ejecutarPagoReq = ejecutarPagoReq;
    }

    public ConsultarFacturaReq getConsultaReq() {
        ConsultarFacturaReq consultarFacturaReq = new ConsultarFacturaReq();
        consultarFacturaReq.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        return consultarFacturaReq;
    }

    public edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.EjecutarPagoReq getPagoReq() {
        edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.EjecutarPagoReq ejecutarPagoReq1
                = new edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.EjecutarPagoReq();
        edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.ConsultarFacturaReq consultarFacturaReq1
                = new edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.dispatcher.wsdl.ConsultarFacturaReq();
        consultarFacturaReq1.setIdFactura(ejecutarPagoReq.getFactura().getIdFactura());
        ejecutarPagoReq1.setFactura(consultarFacturaReq1);
        ejecutarPagoReq1.setValor(ejecutarPagoReq.getValor());
        return ejecutarPagoReq1;
    }

    public edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentaReq getConsultarCuentaReq() {
        edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentaReq consultarCuentaReq = new edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentaReq();
        consultarCuentaReq.setNumero(ejecutarPagoReq.getCuenta().getNumero());
        consultarCuentaReq.setUsuarioId(ejecutarPagoReq.getCuenta().getUsuarioId());
        return consultarCuentaReq;
    }

    public edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ModificarCuentaReq getModificarCuentaReq(boolean compensacion) {
        edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ModificarCuentaReq modificarCuentaReq = new edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ModificarCuentaReq();
        modificarCuentaReq.setNumero(ejecutarPagoReq.getCuenta().getNumero());
        modificarCuentaReq.setUsuarioId(ejecutarPagoReq.getCuenta().getUsuarioId());
        if (compensacion) {
            modificarCuentaReq.setAumento(ejecutarPagoReq.getValor());
            return modificarCuentaReq;
        }
        modificarCuentaReq.setDescuento(ejecutarPagoReq.getValor());
        return modificarCuentaReq;
    }

}
