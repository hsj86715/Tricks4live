package com.tricks4live.exception;

public class DataIntegrityException extends UnsupportedOperationException {
    public DataIntegrityException() {
        this("The operation will broken data integrity");
    }

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityException(Throwable cause) {
        super(cause);
    }

}
