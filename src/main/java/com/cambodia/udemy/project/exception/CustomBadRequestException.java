package com.cambodia.udemy.project.exception;

public class CustomBadRequestException extends RuntimeException{
    public CustomBadRequestException(){
        super();
    }
    public CustomBadRequestException(String message){
        super(message);
    }
}
