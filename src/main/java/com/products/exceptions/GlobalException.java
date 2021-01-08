package com.products.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalException extends RuntimeException {
    private final HttpStatus statusCode;

    public GlobalException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}