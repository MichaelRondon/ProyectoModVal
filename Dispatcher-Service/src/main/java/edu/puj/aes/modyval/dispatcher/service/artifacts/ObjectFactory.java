package edu.puj.aes.modyval.dispatcher.service.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.modyval.dispatcher.service.artifacts package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarFacturaResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/consulta/schemas", "ConsultarFacturaResp");
    private final static QName _EjecutarPagoReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/consulta/schemas", "EjecutarPagoReq");
    private final static QName _ConsultarFacturaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/consulta/schemas", "ConsultarFacturaReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.modyval.dispatcher.service.artifacts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarFacturaReq }
     * 
     */
    public ConsultarFacturaReq createConsultarFacturaReq() {
        return new ConsultarFacturaReq();
    }

    /**
     * Create an instance of {@link EjecutarPagoReq }
     * 
     */
    public EjecutarPagoReq createEjecutarPagoReq() {
        return new EjecutarPagoReq();
    }

    /**
     * Create an instance of {@link ConsultarFacturaResp }
     * 
     */
    public ConsultarFacturaResp createConsultarFacturaResp() {
        return new ConsultarFacturaResp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarFacturaResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", name = "ConsultarFacturaResp")
    public JAXBElement<ConsultarFacturaResp> createConsultarFacturaResp(ConsultarFacturaResp value) {
        return new JAXBElement<ConsultarFacturaResp>(_ConsultarFacturaResp_QNAME, ConsultarFacturaResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarPagoReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", name = "EjecutarPagoReq")
    public JAXBElement<EjecutarPagoReq> createEjecutarPagoReq(EjecutarPagoReq value) {
        return new JAXBElement<EjecutarPagoReq>(_EjecutarPagoReq_QNAME, EjecutarPagoReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarFacturaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/consulta/schemas", name = "ConsultarFacturaReq")
    public JAXBElement<ConsultarFacturaReq> createConsultarFacturaReq(ConsultarFacturaReq value) {
        return new JAXBElement<ConsultarFacturaReq>(_ConsultarFacturaReq_QNAME, ConsultarFacturaReq.class, null, value);
    }

}
