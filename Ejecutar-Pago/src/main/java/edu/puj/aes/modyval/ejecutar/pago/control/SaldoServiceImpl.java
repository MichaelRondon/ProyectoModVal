package edu.puj.aes.modyval.ejecutar.pago.control;

import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentaReq;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentasResp;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ISaldos;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ModificarCuentaReq;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.SaldosService;
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
public class SaldoServiceImpl implements SaldoService {

    @Override
    public ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq consultarCuentaReq) {
        try {
            return (ConsultarCuentasResp) getPort().consultarCuenta(consultarCuentaReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de cuenta con el endpoint: %s, cuenta: %s, usuario: %s, mensaje: %s",
                    SaldoService.WSDL_URI,
                    consultarCuentaReq.getNumero(),
                    consultarCuentaReq.getUsuarioId(),
                    ex.getMessage());
            ConsultarCuentasResp consultarCuentasResp = new ConsultarCuentasResp();
            consultarCuentasResp.setMensajeError(mensajeError);
            consultarCuentasResp.setNumero(consultarCuentaReq.getNumero());
            Logger.getLogger(SaldoServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            return consultarCuentasResp;
        }
    }

    @Override
    public ConsultarCuentasResp modificarCuenta(ModificarCuentaReq modificarCuentaReq) {
        try {
            return (ConsultarCuentasResp) getPort().modificarCuenta(modificarCuentaReq);
        } catch (MalformedURLException ex) {
            String mensajeError = String.format("Error realizando la consulta de cuenta con el endpoint: %s, cuenta: %s, usuario: %s, mensaje: %s",
                    SaldoService.WSDL_URI,
                    modificarCuentaReq.getNumero(),
                    modificarCuentaReq.getUsuarioId(),
                    ex.getMessage());
            ConsultarCuentasResp consultarCuentasResp = new ConsultarCuentasResp();
            consultarCuentasResp.setMensajeError(mensajeError);
            consultarCuentasResp.setNumero(modificarCuentaReq.getNumero());
            Logger.getLogger(SaldoServiceImpl.class.getName()).log(Level.SEVERE, mensajeError, ex);
            return consultarCuentasResp;
        }
    }

    private ISaldos getPort() throws MalformedURLException {
        SaldosService saldosService
                = new SaldosService(new URL(SaldoService.WSDL_URI));
        return saldosService.getSaldosPort();
    }
}
