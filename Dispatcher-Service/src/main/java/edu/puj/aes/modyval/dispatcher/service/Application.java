/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service;


import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.PagosServiceService;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ReferenciaFactura;
import edu.puj.aes.modyval.dispatcher.service.artifacts.wsdl.ResultadoConsulta;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author acost
 */
public class Application {
    
    public static void main(String[] args) throws MalformedURLException {
        PagosServiceService pagosServiceService = new PagosServiceService(new URL("http://192.168.99.100:7070/w1-soap-svr/PagosServiceService?wsdl"));
        ReferenciaFactura referenciaFactura = new ReferenciaFactura();
        referenciaFactura.setReferenciaFactura("7733");
        ResultadoConsulta cosultar = pagosServiceService.getPagosServicePort().cosultar(referenciaFactura);
        System.out.println("cosultar: "+cosultar.getTotalPagar());

    }
}
