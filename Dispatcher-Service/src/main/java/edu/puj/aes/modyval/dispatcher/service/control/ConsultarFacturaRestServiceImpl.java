/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.control;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.EjecutarPagoReq;
import edu.puj.aes.modyval.dispatcher.service.remote.rest.Factura;
import edu.puj.aes.modyval.dispatcher.service.remote.wsdl.Resultado;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@Stateless
public class ConsultarFacturaRestServiceImpl implements ConsultarFacturaRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultarFacturaRestServiceImpl.class);

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        ClientResponse response = createWebResource(consultarFacturaReq).accept("application/json")
                .get(ClientResponse.class);
        if (response.getStatus() != 200) {
            return buildErrorCodeResponse(response,
                    consultarFacturaReq.getIdFactura(), null);
        }
        return convert(response.getEntity(Factura.class));
    }

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq input) {
        ClientResponse response = createWebResource(input.getFactura()).accept("application/json")
                .post(ClientResponse.class);
        if (response.getStatus() != 200) {
            return buildErrorCodeResponse(response,
                    input.getFactura().getIdFactura(), input.getValor());
        }
        return convert(response.getEntity(Resultado.class), input);
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq input) {
        ClientResponse response = createWebResource(input.getFactura()).accept("application/json")
                .delete(ClientResponse.class);
        if (response.getStatus() != 200) {
            return buildErrorCodeResponse(response,
                    input.getFactura().getIdFactura(), input.getValor());
        }
        return convert(response.getEntity(Resultado.class), input);
    }

    private ConsultarFacturaResp buildErrorCodeResponse(ClientResponse response,
            String idFactura, Double valor) {
        String mensajeError
                = String.format("Se obtiene un codigo de error en la petición remota: %s. Respuesta: %s",
                        response.getStatus(), response.getEntity(String.class));
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setMensajeError(mensajeError);
        consultarFacturaResp.setIdFactura(idFactura);
        consultarFacturaResp.setValorFactura(valor);
        consultarFacturaResp.setCodigoError(String.valueOf(response.getStatus()));
        LOGGER.error(mensajeError);
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp convert(Resultado resultado, EjecutarPagoReq input) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setIdFactura(resultado.getReferenciaFactura().getReferenciaFactura());
        consultarFacturaResp.setMensajeError(resultado.getMensaje());
        consultarFacturaResp.setValorFactura(input.getValor());
        return consultarFacturaResp;
    }

    private ConsultarFacturaResp convert(Factura factura) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setIdFactura(String.valueOf(factura.getIdFactura()));
        consultarFacturaResp.setValorFactura(factura.getValorFactura());
        return consultarFacturaResp;
    }

    private WebResource createWebResource(ConsultarFacturaReq consultarFacturaReq) {
        Client client = Client.create();
        return client.resource(
                String.format("%s%s",
                        ConsultarFacturaRestService.ENDPOINT_URL,
                        consultarFacturaReq.getIdFactura()));
    }
}
