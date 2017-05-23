
package edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PagosInerface", targetNamespace = "http://www.servicios.co/pagos/service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PagosInerface {


    /**
     * 
     * @param input
     * @return
     *     returns edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ResultadoConsulta
     */
    @WebMethod(operationName = "Cosultar", action = "consultar")
    @WebResult(name = "ResultadoConsulta", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    @Action(input = "consultar", output = "http://www.servicios.co/pagos/service/PagosInerface/CosultarResponse")
    public ResultadoConsulta cosultar(
        @WebParam(name = "ReferenciaFactura", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        ReferenciaFactura input);

    /**
     * 
     * @param input
     * @return
     *     returns edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.Resultado
     */
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Resultado", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    @Action(input = "pagar", output = "http://www.servicios.co/pagos/service/PagosInerface/PagarResponse")
    public Resultado pagar(
        @WebParam(name = "Pago", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        Pago input);

    /**
     * 
     * @param input
     * @return
     *     returns edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.Resultado
     */
    @WebMethod(operationName = "Compensar", action = "compensar")
    @WebResult(name = "Resultado", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    @Action(input = "compensar", output = "http://www.servicios.co/pagos/service/PagosInerface/CompensarResponse")
    public Resultado compensar(
        @WebParam(name = "Pago", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        Pago input);

}
