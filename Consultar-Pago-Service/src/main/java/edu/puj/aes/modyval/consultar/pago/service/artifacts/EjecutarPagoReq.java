//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.24 a las 08:23:05 PM COT 
//


package edu.puj.aes.modyval.consultar.pago.service.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EjecutarPagoReq complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EjecutarPagoReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="factura" type="{http://www.modval.aes.puj.edu.co/modyval/schemas}ConsultarFacturaReq"/>
 *         &lt;element name="cuenta" type="{http://www.modval.aes.puj.edu.co/modyval/schemas}ConsultarCuentaReq"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EjecutarPagoReq", propOrder = {
    "factura",
    "cuenta",
    "valor"
})
public class EjecutarPagoReq {

    @XmlElement(required = true)
    protected ConsultarFacturaReq factura;
    @XmlElement(required = true)
    protected ConsultarCuentaReq cuenta;
    protected double valor;

    /**
     * Obtiene el valor de la propiedad factura.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarFacturaReq }
     *     
     */
    public ConsultarFacturaReq getFactura() {
        return factura;
    }

    /**
     * Define el valor de la propiedad factura.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarFacturaReq }
     *     
     */
    public void setFactura(ConsultarFacturaReq value) {
        this.factura = value;
    }

    /**
     * Obtiene el valor de la propiedad cuenta.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarCuentaReq }
     *     
     */
    public ConsultarCuentaReq getCuenta() {
        return cuenta;
    }

    /**
     * Define el valor de la propiedad cuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarCuentaReq }
     *     
     */
    public void setCuenta(ConsultarCuentaReq value) {
        this.cuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     */
    public void setValor(double value) {
        this.valor = value;
    }

}
