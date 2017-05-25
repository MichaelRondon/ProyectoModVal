package edu.puj.aes.modyval.ejecutar.pago.boundary;

import edu.puj.aes.modyval.ejecutar.pago.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.ejecutar.pago.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.ejecutar.pago.control.ConsultarConvenioService;
import edu.puj.aes.modyval.ejecutar.pago.control.PagarFacturaService;
import edu.puj.aes.modyval.ejecutar.pago.control.SaldoService;
import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.ejecutar.pago.boundary.EjecutarPago")
public class EjecutarPago implements IEjecutarPago {

    private static final Logger LOGGER = LoggerFactory.getLogger(EjecutarPago.class);

    @EJB
    private ConsultarConvenioService consultarConvenioService;

    @EJB
    private PagarFacturaService pagarFacturaService;

    @EJB
    private SaldoService saldoService;

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq input) {
        RequestTransformer requestTransformer = new RequestTransformer(input);

        //Consulta que el convenio exista y los datos de la factura:
        ConsultarFacturaResp consultarFacturaResp = consultaConvenio(requestTransformer);
        if (hayError(consultarFacturaResp)) {
            return consultarFacturaResp;
        }

        //Modifica el saldo en la cuenta:
        consultarFacturaResp = descontarCuenta(requestTransformer);
        if (hayError(consultarFacturaResp)) {
            return consultarFacturaResp;
        }

        //Ejecuta el pago:
        consultarFacturaResp = ejecutarPago(requestTransformer);
        //Si hay time-out (408 - Request Timeout) envia la compensación del pago:             
        if (consultarFacturaResp.getCodigoError() != null && consultarFacturaResp.getCodigoError().equals("408")) {
            consultarFacturaResp = ejecutarCompensacion(requestTransformer);
        }
        //Si hay problemas envía la compensación del saldo:
        if (hayError(consultarFacturaResp)) {
            compensarEnCuenta(requestTransformer);
        }
        return consultarFacturaResp;
    }

//    @Override
//    public ConsultarFacturaResp compensar(EjecutarPagoReq input) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private ConsultarFacturaResp consultaConvenio(RequestTransformer requestTransformer) {
        String operacion = "Consultar convenio";
        imprimirPeticion(requestTransformer, operacion);
        ConsultarFacturaResp consultarFacturaResp = new ResponseTransformer(
                consultarConvenioService.consultar(requestTransformer.getConsultaReq())).getConsultarFacturaResp();
        imprimirRepuesta(consultarFacturaResp, operacion);
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp descontarCuenta(RequestTransformer requestTransformer) {
        String operacion = "Descontar de la cuenta";
        imprimirPeticion(requestTransformer, operacion);
        ConsultarFacturaResp consultarFacturaResp = new ResponseTransformer(
                saldoService.modificarCuenta(
                        requestTransformer.getModificarCuentaReq(false)),
                requestTransformer.getEjecutarPagoReq()).getConsultarFacturaResp();
        imprimirRepuesta(consultarFacturaResp, operacion);
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp compensarEnCuenta(RequestTransformer requestTransformer) {
        String operacion = "Descontar de la cuenta";
        imprimirPeticion(requestTransformer, operacion);
        ConsultarFacturaResp consultarFacturaResp = new ResponseTransformer(
                saldoService.modificarCuenta(
                        requestTransformer.getModificarCuentaReq(true)),
                requestTransformer.getEjecutarPagoReq()).getConsultarFacturaResp();
        imprimirRepuesta(consultarFacturaResp, operacion);
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp ejecutarPago(RequestTransformer requestTransformer) {
        String operacion = "Ejecutar pago";
        imprimirPeticion(requestTransformer, operacion);
        ConsultarFacturaResp consultarFacturaResp = new ResponseTransformer(
                pagarFacturaService.pagar(
                        requestTransformer.getPagoReq())).getConsultarFacturaResp();
        imprimirRepuesta(consultarFacturaResp, operacion);
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp ejecutarCompensacion(RequestTransformer requestTransformer) {
        String operacion = "Ejecutar compensacion";
        imprimirPeticion(requestTransformer, operacion);
        ConsultarFacturaResp consultarFacturaResp = new ResponseTransformer(
                pagarFacturaService.compensar(
                        requestTransformer.getPagoReq())).getConsultarFacturaResp();
        imprimirRepuesta(consultarFacturaResp, operacion);
        return consultarFacturaResp;
    }

    private void imprimirPeticion(RequestTransformer requestTransformer, String operacion) {
        LOGGER.info("Petición de la operación: {}. Cuenta: {}. Usuario id: {}. Factura id: {}. Valor: {}.",
                operacion,
                requestTransformer.getEjecutarPagoReq().getCuenta().getNumero(),
                requestTransformer.getEjecutarPagoReq().getCuenta().getUsuarioId(),
                requestTransformer.getEjecutarPagoReq().getFactura().getIdFactura(),
                requestTransformer.getEjecutarPagoReq().getValor());
        System.out.println(String.format("Petición de la operación: %s. Cuenta: %s. Usuario id: %s. Factura id: %s. Valor: %s.",
                operacion,
                requestTransformer.getEjecutarPagoReq().getCuenta().getNumero(),
                requestTransformer.getEjecutarPagoReq().getCuenta().getUsuarioId(),
                requestTransformer.getEjecutarPagoReq().getFactura().getIdFactura(),
                requestTransformer.getEjecutarPagoReq().getValor()));
    }

    private void imprimirRepuesta(ConsultarFacturaResp consultarFacturaResp, String operacion) {
        LOGGER.info("Respuesta de la operación: {}. Mensaje: {}. Factura id: {}. Valor: {}.",
                operacion,
                consultarFacturaResp.getMensajeError(),
                consultarFacturaResp.getIdFactura(),
                consultarFacturaResp.getValorFactura());
        System.out.println(String.format("Respuesta de la operación: %s. Mensaje: %s. Factura id: %s. Valor: %s.",
                operacion,
                consultarFacturaResp.getMensajeError(),
                consultarFacturaResp.getIdFactura(),
                consultarFacturaResp.getValorFactura()));
    }

    private boolean hayError(ConsultarFacturaResp consultarFacturaResp) {
        return Objects.nonNull(consultarFacturaResp)
                && Objects.nonNull(consultarFacturaResp.getMensajeError())
                && !consultarFacturaResp.getMensajeError().isEmpty()
                && !consultarFacturaResp.getMensajeError().equals("Factura Pagada Exitosamente");
    }
}
