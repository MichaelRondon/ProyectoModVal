package edu.puj.aes.modyval.ejecutar.pago.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarSaldoResp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarSaldoResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuentas" type="{http://www.modval.aes.puj.edu.co/consulta/schemas}Cuentas"/>
 *         &lt;element name="usuarioId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarSaldoResp", propOrder = {
    "cuentas",
    "usuarioId",
    "mensajeError"
})
public class ConsultarSaldoResp {

    @XmlElement(required = true)
    protected Cuentas cuentas;
    @XmlElement(required = true)
    protected String usuarioId;
    @XmlElement(required = true)
    protected String mensajeError;

    /**
     * Obtiene el valor de la propiedad cuentas.
     * 
     * @return
     *     possible object is
     *     {@link Cuentas }
     *     
     */
    public Cuentas getCuentas() {
        return cuentas;
    }

    /**
     * Define el valor de la propiedad cuentas.
     * 
     * @param value
     *     allowed object is
     *     {@link Cuentas }
     *     
     */
    public void setCuentas(Cuentas value) {
        this.cuentas = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioId() {
        return usuarioId;
    }

    /**
     * Define el valor de la propiedad usuarioId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioId(String value) {
        this.usuarioId = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Define el valor de la propiedad mensajeError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeError(String value) {
        this.mensajeError = value;
    }

}
