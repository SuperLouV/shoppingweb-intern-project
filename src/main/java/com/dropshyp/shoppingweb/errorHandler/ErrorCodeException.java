package com.dropshyp.shoppingweb.errorHandler;

import org.springframework.http.HttpStatus;

public class ErrorCodeException extends RuntimeException {

    private final int code;
    private final String message;
    private final HttpStatus status;

    public ErrorCodeException(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
