/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.ejecutar.pago.control;

import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentaReq;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ConsultarCuentasResp;
import edu.puj.aes.modyval.ejecutar.pago.remote.artifacts.saldos.wsdl.ModificarCuentaReq;
import javax.ejb.Local;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
@Local
public interface SaldoService {
    
    public static final String WSDL_URI = "http://saldos_service:8080/saldos-service/SaldosService?wsdl";

    ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq consultarCuentaReq);
    ConsultarCuentasResp modificarCuenta(ModificarCuentaReq modificarCuentaReq);
}
