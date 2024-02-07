package com.cambodia.udemy.project.exception;

public class CustomUnauthorizedException extends RuntimeException{
    public CustomUnauthorizedException(){}

    public CustomUnauthorizedException(String message){
        super(message);
    }
}
