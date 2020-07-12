package com.dropshyp.shoppingweb.errorHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = ErrorCodeException.class)
    public final ResponseEntity<RestErrorResponse> handleBadRequestException(ErrorCodeException errorCodeException) {
        RestErrorResponse restErrorResponse = new RestErrorResponse(errorCodeException.getCode(), errorCodeException.getMessage());
        return new ResponseEntity<>(restErrorResponse, errorCodeException.getStatus());
    }
}
