/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.authentication.service.boundary;

import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationInterface;
import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationReq;
import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationResp;
import edu.puj.aes.modyval.authentication.service.control.AuthenticationService;
import javax.ejb.EJB;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@WebService(endpointInterface = "edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationInterface")
public class Authentication implements AuthenticationInterface {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Authentication.class);
    
    @EJB
    AuthenticationService authenticationServiceImpl;
    
    @Override
    public AuthenticationResp autenticar(AuthenticationReq input) {
        LOGGER.info("AuthenticationService. Login:{}", input.getLogin());
        return authenticationServiceImpl.autenticar(input);
    }
    
}
