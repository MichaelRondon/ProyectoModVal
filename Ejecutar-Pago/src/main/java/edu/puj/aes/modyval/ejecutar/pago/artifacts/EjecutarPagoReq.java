package edu.puj.aes.modyval.ejecutar.pago.artifacts;

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
 *         &lt;element name="factura" type="{http://www.modval.aes.puj.edu.co/consulta/schemas}ConsultarFacturaReq"/>
 *         &lt;element name="cuenta" type="{http://www.modval.aes.puj.edu.co/consulta/schemas}ConsultarCuentaReq"/>
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
