package com.springBootProject.orderService.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
