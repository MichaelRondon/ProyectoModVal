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
import edu.puj.aes.modyval.saldos.service.control.SaldoService;
import javax.ejb.EJB;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.saldos.service.artifacts.ISaldos")
public class Saldos implements ISaldos {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Saldos.class);

    @EJB
    private SaldoService saldoService;

    @Override
    public ConsultarSaldoResp consultar(ConsultarSaldoReq input) {
        LOGGER.info("SaldosService: {}", input);
        return saldoService.consultar(input);
    }

    @Override
    public ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq input) {
        LOGGER.info("SaldosService: {}", input);
        return saldoService.consultarCuenta(input);
    }

    @Override
    public ConsultarCuentasResp modificarCuenta(ModificarCuentaReq input) {
        LOGGER.info("SaldosService: {}", input);
        return saldoService.modificarCuenta(input);
    }
}
