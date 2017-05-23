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
import edu.puj.aes.modyval.dispatcher.service.artifacts.rest.Factura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.rest.Resultado;
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
        Client client = Client.create();
        WebResource webResource
                = client.resource(
                        String.format("%s%s",
                                ConsultarFacturaRestService.ENDPOINT_URL,
                                consultarFacturaReq.getIdFactura()));

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new ConsultarFacturaException(
                    String.format("Failed : HTTP error code : %s", response.getStatus()));
        }

        return convert(response.getEntity(Factura.class));
    }

    @Override
    public Resultado pagar(String idFactura, double valorFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado compensar(String idFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ConsultarFacturaResp convert(Factura factura) {
        ConsultarFacturaResp consultarFacturaResp = new ConsultarFacturaResp();
        consultarFacturaResp.setIdFactura(String.valueOf(factura.getIdFactura()));
        consultarFacturaResp.setValorFactura(factura.getValorFactura());
        return consultarFacturaResp;
    }
}
