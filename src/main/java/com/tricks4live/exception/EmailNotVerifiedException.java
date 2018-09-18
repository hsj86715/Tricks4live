package com.tricks4live.exception;

public class EmailNotVerifiedException extends IllegalStateException {
    public EmailNotVerifiedException() {
        this("User email has not been verified.");
    }

    public EmailNotVerifiedException(String s) {
        super(s);
    }

    public EmailNotVerifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotVerifiedException(Throwable cause) {
        super(cause);
    }

}
