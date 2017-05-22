/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.saldos.service.artifacts;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public interface ISaldos {
    ConsultarSaldoResp consultar(ConsultarSaldoReq input);
    ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq input);
    ConsultarCuentasResp modificarCuenta(ModificarCuentaReq input);
}
