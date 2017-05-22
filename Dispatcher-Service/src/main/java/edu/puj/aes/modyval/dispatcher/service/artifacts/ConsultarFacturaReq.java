package edu.puj.aes.modyval.dispatcher.service.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarFacturaReq complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarFacturaReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consultarFacturaBaseReq" type="{http://www.modval.aes.puj.edu.co/consulta/schemas}ConsultarFacturaBaseReq"/>
 *         &lt;element name="endpoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarFacturaReq", propOrder = {
    "consultarFacturaBaseReq",
    "endpoint"
})
public class ConsultarFacturaReq {

    @XmlElement(required = true)
    protected ConsultarFacturaBaseReq consultarFacturaBaseReq;
    @XmlElement(required = true)
    protected String endpoint;

    /**
     * Obtiene el valor de la propiedad consultarFacturaBaseReq.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarFacturaBaseReq }
     *     
     */
    public ConsultarFacturaBaseReq getConsultarFacturaBaseReq() {
        return consultarFacturaBaseReq;
    }

    /**
     * Define el valor de la propiedad consultarFacturaBaseReq.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarFacturaBaseReq }
     *     
     */
    public void setConsultarFacturaBaseReq(ConsultarFacturaBaseReq value) {
        this.consultarFacturaBaseReq = value;
    }

    /**
     * Obtiene el valor de la propiedad endpoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Define el valor de la propiedad endpoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpoint(String value) {
        this.endpoint = value;
    }

}
