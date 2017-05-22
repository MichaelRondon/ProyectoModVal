/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.puj.aes.modyval.dispatcher.service.exception;

/**
 *
 * @author acost
 */
public class ConsultarFacturaException extends RuntimeException{

    public ConsultarFacturaException() {
    }

    public ConsultarFacturaException(String message) {
        super(message);
    }

    public ConsultarFacturaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsultarFacturaException(Throwable cause) {
        super(cause);
    }

    public ConsultarFacturaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
