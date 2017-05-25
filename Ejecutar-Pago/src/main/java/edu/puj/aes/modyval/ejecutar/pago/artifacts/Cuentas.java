package edu.puj.aes.modyval.ejecutar.pago.artifacts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Cuentas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Cuentas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.modval.aes.puj.edu.co/modyval/schemas}ConsultarCuentasResp" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cuentas", propOrder = {
    "consultarCuentasResp"
})
public class Cuentas {

    @XmlElement(name = "ConsultarCuentasResp")
    protected List<ConsultarCuentasResp> consultarCuentasResp;

    /**
     * Gets the value of the consultarCuentasResp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consultarCuentasResp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsultarCuentasResp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultarCuentasResp }
     * 
     * 
     */
    public List<ConsultarCuentasResp> getConsultarCuentasResp() {
        if (consultarCuentasResp == null) {
            consultarCuentasResp = new ArrayList<ConsultarCuentasResp>();
        }
        return this.consultarCuentasResp;
    }

}
