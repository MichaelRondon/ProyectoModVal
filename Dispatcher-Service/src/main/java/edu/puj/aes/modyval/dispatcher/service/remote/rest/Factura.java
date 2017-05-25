/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.remote.rest;

/**
 *
 * @author acost
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Factura {

    private int idFactura;
    private double valorFactura;

    public Factura() {
    }

    public Factura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Factura(int idFactura, double valorFactura) {
        this.idFactura = idFactura;
        this.valorFactura = valorFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }
}
