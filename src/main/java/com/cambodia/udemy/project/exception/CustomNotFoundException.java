package com.cambodia.udemy.project.exception;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(){}

    public CustomNotFoundException(String message){
        super(message);
    }
}
