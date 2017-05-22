package edu.puj.aes.modyval.saldos.service.exception;

/**
 *
 * @author Michael Felipe Rondón Acosta
 */
public class SaldosException extends RuntimeException{

    public SaldosException() {
    }

    public SaldosException(String message) {
        super(message);
    }

    public SaldosException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaldosException(Throwable cause) {
        super(cause);
    }

    public SaldosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
