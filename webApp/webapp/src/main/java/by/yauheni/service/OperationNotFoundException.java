package by.yauheni.service;

public class OperationNotFoundException extends RuntimeException {
    public OperationNotFoundException(String message) {
        super(message);
    }

    public OperationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OperationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OperationNotFoundException() {

    }
}
