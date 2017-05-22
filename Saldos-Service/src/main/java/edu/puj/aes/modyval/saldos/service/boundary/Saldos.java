/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.saldos.service.boundary;

import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentaReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentasResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ISaldos;
import edu.puj.aes.modyval.saldos.service.artifacts.ModificarCuentaReq;
import javax.jws.WebService;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.saldos.service.artifacts.ISaldos")
public class Saldos implements ISaldos {

    @Override
    public ConsultarSaldoResp consultar(ConsultarSaldoReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConsultarCuentasResp modificarCuenta(ModificarCuentaReq input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
