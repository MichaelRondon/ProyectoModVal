
package edu.puj.aes.modyval.authentication.service.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.puj.aes.modyval.authentication.service.artifacts package. 
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

    private final static QName _AuthenticationResp_QNAME = new QName("http://www.modval.aes.puj.edu.co/authentication/schemas", "AuthenticationResp");
    private final static QName _AuthenticationReq_QNAME = new QName("http://www.modval.aes.puj.edu.co/authentication/schemas", "AuthenticationReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.puj.aes.modyval.authentication.service.artifacts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthenticationResp }
     * 
     */
    public AuthenticationResp createAuthenticationResp() {
        return new AuthenticationResp();
    }

    /**
     * Create an instance of {@link AuthenticationReq }
     * 
     */
    public AuthenticationReq createAuthenticationReq() {
        return new AuthenticationReq();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationResp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/authentication/schemas", name = "AuthenticationResp")
    public JAXBElement<AuthenticationResp> createAuthenticationResp(AuthenticationResp value) {
        return new JAXBElement<AuthenticationResp>(_AuthenticationResp_QNAME, AuthenticationResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.modval.aes.puj.edu.co/authentication/schemas", name = "AuthenticationReq")
    public JAXBElement<AuthenticationReq> createAuthenticationReq(AuthenticationReq value) {
        return new JAXBElement<AuthenticationReq>(_AuthenticationReq_QNAME, AuthenticationReq.class, null, value);
    }

}
