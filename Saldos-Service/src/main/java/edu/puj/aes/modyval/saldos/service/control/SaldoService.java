/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.saldos.service.control;

import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentaReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarCuentasResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoReq;
import edu.puj.aes.modyval.saldos.service.artifacts.ConsultarSaldoResp;
import edu.puj.aes.modyval.saldos.service.artifacts.ModificarCuentaReq;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface SaldoService {

    ConsultarSaldoResp consultar(ConsultarSaldoReq authenticationReq);
    ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq authenticationReq);
    ConsultarCuentasResp modificarCuenta(ModificarCuentaReq authenticationReq);
}
