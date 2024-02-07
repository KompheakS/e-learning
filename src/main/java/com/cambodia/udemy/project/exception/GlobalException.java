package com.cambodia.udemy.project.exception;

public class GlobalException extends RuntimeException{
    private static final long serialVersionUID = -470180507998010368L;

    public GlobalException(){
        super();
    }

    public GlobalException(final String message){
        super(message);
    }
}
