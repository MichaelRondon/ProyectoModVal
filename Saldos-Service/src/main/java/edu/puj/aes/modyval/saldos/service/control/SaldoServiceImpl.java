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
import edu.puj.aes.modyval.saldos.service.artifacts.Cuentas;
import edu.puj.aes.modyval.saldos.service.artifacts.ModificarCuentaReq;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@Stateless
public class SaldoServiceImpl implements SaldoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaldoServiceImpl.class);
    private static final Map<String, Map<String, BigDecimal>> MAPA_CUENTAS_USUARIOS = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, BigDecimal> cuentas = new HashMap<>();
        cuentas.put("123456789", new BigDecimal(500000.0));
        cuentas.put("123456790", new BigDecimal(1000000.0));
        MAPA_CUENTAS_USUARIOS.put("0001", cuentas);
        cuentas = new HashMap<>();
        cuentas.put("123456791", new BigDecimal(500000.0));
        cuentas.put("123456792", new BigDecimal(1000000.0));
        MAPA_CUENTAS_USUARIOS.put("0002", cuentas);
        cuentas = new HashMap<>();
        cuentas.put("123456793", new BigDecimal(500000.0));
        cuentas.put("123456794", new BigDecimal(1000000.0));
        MAPA_CUENTAS_USUARIOS.put("0003", cuentas);
        cuentas = new HashMap<>();
        cuentas.put("123456795", new BigDecimal(500000.0));
        cuentas.put("123456796", new BigDecimal(1000000.0));
        MAPA_CUENTAS_USUARIOS.put("0004", cuentas);
        cuentas = new HashMap<>();
        cuentas.put("123456797", new BigDecimal(500000.0));
        cuentas.put("123456798", new BigDecimal(1000000.0));
        MAPA_CUENTAS_USUARIOS.put("0005", cuentas);
    }

    @Override
    public ConsultarSaldoResp consultar(ConsultarSaldoReq consultarSaldoReq) {
        String usuarioId = consultarSaldoReq.getUsuarioId();
        ConsultarSaldoResp consultarSaldoResp = new ConsultarSaldoResp();
        consultarSaldoResp.setUsuarioId(usuarioId);

        if (!MAPA_CUENTAS_USUARIOS.containsKey(usuarioId)) {
            consultarSaldoResp.setMensajeError(String.format("El usuario con id: %s No tiene cuentas", usuarioId));
            return consultarSaldoResp;
        }

        Map<String, BigDecimal> cuentas = MAPA_CUENTAS_USUARIOS.get(usuarioId);
        Cuentas cuentas_ = new Cuentas();
        List<ConsultarCuentasResp> consultarCuentas = cuentas_.getConsultarCuentasResp();
        cuentas.entrySet().forEach(entry -> consultarCuentas.add(crearConsultarCuentasResp(entry.getKey(), entry.getValue())));
        consultarSaldoResp.setCuentas(cuentas_);
        return consultarSaldoResp;
    }

    @Override
    public ConsultarCuentasResp consultarCuenta(ConsultarCuentaReq consultarCuentaReq) {
        String usuarioId = consultarCuentaReq.getUsuarioId();
        String numero = consultarCuentaReq.getNumero();
        return consultarCuenta(usuarioId, numero);
    }

    @Override
    public synchronized ConsultarCuentasResp modificarCuenta(ModificarCuentaReq modificarCuentaReq) {
        String usuarioId = modificarCuentaReq.getUsuarioId();
        String numero = modificarCuentaReq.getNumero();
        ConsultarCuentasResp consultarCuentasResp = consultarCuenta(usuarioId, numero);
        double nuevoSaldo = consultarCuentasResp.getSaldo();
        if (modificarCuentaReq.getDescuento() > 0D) {
            if (consultarCuentasResp.getSaldo() < modificarCuentaReq.getDescuento()) {
                consultarCuentasResp.setMensajeError(String.format("Saldo insuficiente: %f", consultarCuentasResp.getSaldo()));
                return consultarCuentasResp;
            }
            nuevoSaldo = nuevoSaldo - modificarCuentaReq.getDescuento();
        }
        if (modificarCuentaReq.getAumento() > 0D) {
            nuevoSaldo = nuevoSaldo + modificarCuentaReq.getAumento();
        }
        asignarNuevoSaldo(usuarioId, numero, nuevoSaldo);
        consultarCuentasResp.setSaldo(nuevoSaldo);
        return consultarCuentasResp;
    }

    private synchronized void asignarNuevoSaldo(String usuarioId, String numero, double nuevoSaldo) {
        Map<String, BigDecimal> cuentas = MAPA_CUENTAS_USUARIOS.get(usuarioId);
        if (cuentas != null) {
            cuentas.put(numero, new BigDecimal(nuevoSaldo));
        }
    }

    private ConsultarCuentasResp consultarCuenta(String usuarioId, String numero) {
        ConsultarCuentasResp consultarCuentasResp = new ConsultarCuentasResp();

        if (!MAPA_CUENTAS_USUARIOS.containsKey(usuarioId)) {
            consultarCuentasResp.setMensajeError(String.format("El usuario con id: %s No tiene cuentas", usuarioId));
            return consultarCuentasResp;
        }

        Map<String, BigDecimal> cuentas = MAPA_CUENTAS_USUARIOS.get(usuarioId);
        if (!cuentas.containsKey(numero)) {
            consultarCuentasResp.setMensajeError(
                    String.format("El usuario con id: %s No tiene la cuenta %s",
                            usuarioId, numero));
            return consultarCuentasResp;
        }
        BigDecimal saldo = cuentas.get(numero);
        return crearConsultarCuentasResp(numero, saldo);

    }

    private ConsultarCuentasResp crearConsultarCuentasResp(String numeroCuenta, BigDecimal saldo) {
        ConsultarCuentasResp consultarCuentasResp = new ConsultarCuentasResp();
        consultarCuentasResp.setNumero(numeroCuenta);
        consultarCuentasResp.setSaldo(saldo.doubleValue());
        return consultarCuentasResp;
    }

}
