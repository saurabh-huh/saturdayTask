package com.springBootProject.customerService.exception;


public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
