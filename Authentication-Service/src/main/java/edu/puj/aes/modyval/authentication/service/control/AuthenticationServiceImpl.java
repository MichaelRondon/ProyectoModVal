/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.authentication.service.control;

import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationReq;
import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationResp;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acost
 */
@Stateless
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public AuthenticationResp autenticar(AuthenticationReq authenticationReq) {
        LOGGER.debug("Petición: {}", authenticationReq);
        AuthenticationResp authenticationResp = new AuthenticationResp();
        switch (authenticationReq.getLogin()) {
            case "david":
                authenticationResp.setUsuarioId("0001");
                break;
            case "diego":
                authenticationResp.setUsuarioId("0002");
                break;
            case "felipe":
                authenticationResp.setUsuarioId("0003");
                break;
            case "marcela":
                authenticationResp.setUsuarioId("0004");
                break;
            case "michael":
                authenticationResp.setUsuarioId("0005");
                break;
        }
        return authenticationResp;
    }
}
