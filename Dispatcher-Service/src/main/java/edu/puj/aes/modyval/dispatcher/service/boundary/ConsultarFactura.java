/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.boundary;

import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.dispatcher.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.dispatcher.service.artifacts.IConsultarFactura;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.dispatcher.service.artifacts.IConsultarFactura")
public class ConsultarFactura implements IConsultarFactura {

    @EJB
    private IConsultarFactura consultarFactura;

    public ConsultarFacturaResp consultar(ConsultarFacturaReq input) {
        return consultarFactura.consultar(input);
    }

}
