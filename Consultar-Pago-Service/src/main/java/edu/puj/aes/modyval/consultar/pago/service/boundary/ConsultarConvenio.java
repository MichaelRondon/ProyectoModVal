/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.consultar.pago.service.boundary;

import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaReq;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.ConsultarFacturaResp;
import edu.puj.aes.modyval.consultar.pago.service.artifacts.IConsultarConvenios;
import javax.jws.WebService;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.consultar.pago.service.artifacts.IConsultarConvenios")
public class ConsultarConvenio implements IConsultarConvenios {

    @Override
    public ConsultarFacturaResp consultar(ConsultarFacturaReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
