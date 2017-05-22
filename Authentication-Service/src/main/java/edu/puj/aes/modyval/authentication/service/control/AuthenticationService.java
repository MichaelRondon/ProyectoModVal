/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.authentication.service.control;

import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationReq;
import edu.puj.aes.modyval.authentication.service.artifacts.AuthenticationResp;
import javax.ejb.Local;

/**
 *
 * @author acost
 */
@Local
public interface AuthenticationService {

    AuthenticationResp autenticar(AuthenticationReq authenticationReq);
}
