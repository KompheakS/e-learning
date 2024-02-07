package com.cambodia.udemy.project.exception;

public class CustomForbiddenException extends RuntimeException{
    public CustomForbiddenException(){
    }

    public CustomForbiddenException(String message){
        super(message);
    }
}
