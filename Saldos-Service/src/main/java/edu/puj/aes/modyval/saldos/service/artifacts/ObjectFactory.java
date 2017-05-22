//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.22 a las 05:10:30 PM COT 
//


package edu.puj.aes.modyval.saldos.service.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.modyval.consultar.saldos.service.artifacts package. 
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

    private final static QName _ConsultarSaldoReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/saldo/schemas", "ConsultarSaldoReq");
    private final static QName _ConsultarCuentasResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/saldo/schemas", "ConsultarCuentasResp");
    private final static QName _ModificarCuentaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/saldo/schemas", "ModificarCuentaReq");
    private final static QName _ConsultarCuentaReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/saldo/schemas", "ConsultarCuentaReq");
    private final static QName _ConsultarSaldoResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/saldo/schemas", "ConsultarSaldoResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.modyval.consultar.saldos.service.artifacts
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
     * Create an instance of {@link ModificarCuentaReq }
     * 
     */
    public ModificarCuentaReq createModificarCuentaReq() {
        return new ModificarCuentaReq();
    }

    /**
     * Create an instance of {@link ConsultarCuentaReq }
     * 
     */
    public ConsultarCuentaReq createConsultarCuentaReq() {
        return new ConsultarCuentaReq();
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
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", name = "ConsultarSaldoReq")
    public JAXBElement<ConsultarSaldoReq> createConsultarSaldoReq(ConsultarSaldoReq value) {
        return new JAXBElement<ConsultarSaldoReq>(_ConsultarSaldoReq_QNAME, ConsultarSaldoReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentasResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", name = "ConsultarCuentasResp")
    public JAXBElement<ConsultarCuentasResp> createConsultarCuentasResp(ConsultarCuentasResp value) {
        return new JAXBElement<ConsultarCuentasResp>(_ConsultarCuentasResp_QNAME, ConsultarCuentasResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCuentaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", name = "ModificarCuentaReq")
    public JAXBElement<ModificarCuentaReq> createModificarCuentaReq(ModificarCuentaReq value) {
        return new JAXBElement<ModificarCuentaReq>(_ModificarCuentaReq_QNAME, ModificarCuentaReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCuentaReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", name = "ConsultarCuentaReq")
    public JAXBElement<ConsultarCuentaReq> createConsultarCuentaReq(ConsultarCuentaReq value) {
        return new JAXBElement<ConsultarCuentaReq>(_ConsultarCuentaReq_QNAME, ConsultarCuentaReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/saldo/schemas", name = "ConsultarSaldoResp")
    public JAXBElement<ConsultarSaldoResp> createConsultarSaldoResp(ConsultarSaldoResp value) {
        return new JAXBElement<ConsultarSaldoResp>(_ConsultarSaldoResp_QNAME, ConsultarSaldoResp.class, null, value);
    }

}
