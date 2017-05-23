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
import edu.puj.aes.modyval.dispatcher.service.artifacts.rest.Factura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.Resultado;
import edu.puj.aes.modyval.dispatcher.service.exception.ConsultarFacturaException;
import javax.ejb.Stateless;

/**
 *
 * @author acost
 */
@Stateless
public class ConsultarFacturaRestServiceImpl implements ConsultarFacturaRestService {

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq consultarFacturaReq) {
        ClientResponse response = createWebResource(consultarFacturaReq).accept("application/json")
                .get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new ConsultarFacturaException(
                    String.format("Failed : HTTP error code : %s", response.getStatus()));
        }
        return convert(response.getEntity(Factura.class));
    }

    @Override
    public ConsultarFacturaResp pagar(EjecutarPagoReq input) {
        ClientResponse response = createWebResource(input.getFactura()).accept("application/json")
                .post(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new ConsultarFacturaException(
                    String.format("Failed : HTTP error code : %s", response.getStatus()));
        }
        return convert(response.getEntity(Resultado.class), input);
    }

    @Override
    public ConsultarFacturaResp compensar(EjecutarPagoReq input) {
        ClientResponse response = createWebResource(input.getFactura()).accept("application/json")
                .delete(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new ConsultarFacturaException(
                    String.format("Failed : HTTP error code : %s", response.getStatus()));
        }
        return convert(response.getEntity(Resultado.class), input);
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
