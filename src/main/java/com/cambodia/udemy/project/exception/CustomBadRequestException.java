package com.cambodia.udemy.project.exception;

import com.cambodia.udemy.project.dto.CustomErrorResponseException;

public class CustomBadRequestException extends RuntimeException{
    public CustomBadRequestException(){
        super();
    }
    public CustomBadRequestException(String message){
        super(message);
    }
}
