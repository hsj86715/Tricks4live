package com.tricks4live.exception;

public class PermissionException extends EmailNotVerifiedException{
    public PermissionException() {
        this("User permission is prohibited.");
    }

    public PermissionException(String s) {
        super(s);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }
}
