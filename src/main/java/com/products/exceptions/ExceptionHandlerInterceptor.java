package com.products.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    public ResponseEntity<GlobalException> captureException(GlobalException exception) {
        return new ResponseEntity<>(exception, exception.getStatusCode());
    }

}
