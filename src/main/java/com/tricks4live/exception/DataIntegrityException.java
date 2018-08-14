package com.tricks4live.exception;

public class DataIntegrityException extends UnsupportedOperationException {
    public DataIntegrityException() {
        super("The operation will broken data integrity");
    }
}
