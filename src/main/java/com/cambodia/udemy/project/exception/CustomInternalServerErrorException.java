package com.cambodia.udemy.project.exception;

public class CustomInternalServerErrorException extends RuntimeException{
    public CustomInternalServerErrorException(){}

    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
