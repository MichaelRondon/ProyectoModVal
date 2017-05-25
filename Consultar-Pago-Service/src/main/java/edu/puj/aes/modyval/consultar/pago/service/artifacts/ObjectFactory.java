//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.24 a las 08:23:05 PM COT 
//


package edu.puj.aes.modyval.consultar.pago.service.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.modyval.consultar.pago.service.artifacts package. 
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

    private final static QName _ConsultarSaldoReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarSaldoReq");
    private final static QName _ConsultarFacturaResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarFacturaResp");
    private final static QName _ConsultarCuentasResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarCuentasResp");
    private final static QName _AuthenticationReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "AuthenticationReq");
    private final static QName _ConsultarCuentaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarCuentaReq");
    private final static QName _ModificarCuentaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ModificarCuentaReq");
    private final static QName _AuthenticationResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "AuthenticationResp");
    private final static QName _EjecutarPagoReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "EjecutarPagoReq");
    private final static QName _ConsultarFacturaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarFacturaReq");
    private final static QName _ConsultarSaldoResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/modyval/schemas", "ConsultarSaldoResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.modyval.consultar.pago.service.artifacts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarSaldoResp }
     * 
     */
    public ConsultarSaldoResp createConsultarSaldoResp() {
        return new ConsultarSaldoResp();
    }

    /**
     * Create an instance of {@link ConsultarFacturaReq }
     * 
     */
    public ConsultarFacturaReq createConsultarFacturaReq() {
        return new ConsultarFacturaReq();
    }

    /**
     * Create an instance of {@link AuthenticationResp }
     * 
     */
    public AuthenticationResp createAuthenticationResp() {
        return new AuthenticationResp();
    }

    /**
     * Create an instance of {@link EjecutarPagoReq }
     * 
     */
    public EjecutarPagoReq createEjecutarPagoReq() {
        return new EjecutarPagoReq();
    }

    /**
     * Create an instance of {@link ModificarCuentaReq }
     * 
     */
    public ModificarCuentaReq createModificarCuentaReq() {
        return new ModificarCuentaReq();
    }

    /**
     * Create an instance of {@link AuthenticationReq }
     * 
     */
    public AuthenticationReq createAuthenticationReq() {
        return new AuthenticationReq();
    }

    /**
     * Create an instance of {@link ConsultarCuentaReq }
     * 
     */
    public ConsultarCuentaReq createConsultarCuentaReq() {
        return new ConsultarCuentaReq();
    }

    /**
     * Create an instance of {@link ConsultarFacturaResp }
     * 
     */
    public ConsultarFacturaResp createConsultarFacturaResp() {
        return new ConsultarFacturaResp();
    }

    /**
     * Create an instance of {@link ConsultarCuentasResp }
     * 
     */
    public ConsultarCuentasResp createConsultarCuentasResp() {
        return new ConsultarCuentasResp();
    }

    /**
     * Create an instance of {@link ConsultarSaldoReq }
     * 
     */
    public ConsultarSaldoReq createConsultarSaldoReq() {
        return new ConsultarSaldoReq();
    }

    /**
     * Create an instance of {@link Cuentas }
     * 
     */
    public Cuentas createCuentas() {
        return new Cuentas();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarSaldoReq")
    public JAXBElement<ConsultarSaldoReq> createConsultarSaldoReq(ConsultarSaldoReq value) {
        return new JAXBElement<ConsultarSaldoReq>(_ConsultarSaldoReq_QNAME, ConsultarSaldoReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarFacturaResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarFacturaResp")
    public JAXBElement<ConsultarFacturaResp> createConsultarFacturaResp(ConsultarFacturaResp value) {
        return new JAXBElement<ConsultarFacturaResp>(_ConsultarFacturaResp_QNAME, ConsultarFacturaResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentasResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarCuentasResp")
    public JAXBElement<ConsultarCuentasResp> createConsultarCuentasResp(ConsultarCuentasResp value) {
        return new JAXBElement<ConsultarCuentasResp>(_ConsultarCuentasResp_QNAME, ConsultarCuentasResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "AuthenticationReq")
    public JAXBElement<AuthenticationReq> createAuthenticationReq(AuthenticationReq value) {
        return new JAXBElement<AuthenticationReq>(_AuthenticationReq_QNAME, AuthenticationReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarCuentaReq")
    public JAXBElement<ConsultarCuentaReq> createConsultarCuentaReq(ConsultarCuentaReq value) {
        return new JAXBElement<ConsultarCuentaReq>(_ConsultarCuentaReq_QNAME, ConsultarCuentaReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCuentaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ModificarCuentaReq")
    public JAXBElement<ModificarCuentaReq> createModificarCuentaReq(ModificarCuentaReq value) {
        return new JAXBElement<ModificarCuentaReq>(_ModificarCuentaReq_QNAME, ModificarCuentaReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "AuthenticationResp")
    public JAXBElement<AuthenticationResp> createAuthenticationResp(AuthenticationResp value) {
        return new JAXBElement<AuthenticationResp>(_AuthenticationResp_QNAME, AuthenticationResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarPagoReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "EjecutarPagoReq")
    public JAXBElement<EjecutarPagoReq> createEjecutarPagoReq(EjecutarPagoReq value) {
        return new JAXBElement<EjecutarPagoReq>(_EjecutarPagoReq_QNAME, EjecutarPagoReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarFacturaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarFacturaReq")
    public JAXBElement<ConsultarFacturaReq> createConsultarFacturaReq(ConsultarFacturaReq value) {
        return new JAXBElement<ConsultarFacturaReq>(_ConsultarFacturaReq_QNAME, ConsultarFacturaReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/modyval/schemas", name = "ConsultarSaldoResp")
    public JAXBElement<ConsultarSaldoResp> createConsultarSaldoResp(ConsultarSaldoResp value) {
        return new JAXBElement<ConsultarSaldoResp>(_ConsultarSaldoResp_QNAME, ConsultarSaldoResp.class, null, value);
    }

}
