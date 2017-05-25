/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.remote.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acost
 */
@XmlRootElement
public class Resultado {

    protected int idFactura;
    protected String mensaje;

    public Resultado() {
    }

    public Resultado(int idFactura, String mensaje) {
        this.idFactura = idFactura;
        this.mensaje = mensaje;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
