package com.cambodia.udemy.project.utils;

import lombok.Data;

@Data
public class MessageResponse {
    public static final String MESSAGE_SUCCESS = "success";
    public static final String MESSAGE_FAIL = "fail";
    public static final String MESSAGE_NULL = "null";
    public static final String SUCCESS_CREATED_USER = "success created new user";
    public static final String SUCCESS_VERIFICATION_CODE = "user verify successfully!";

    public static String categoryReturnCreated(){
        return "New Category Was Created!";
    }

    public static String categoryReturnDelete(){
        return "delete category successfully!";
    }
}
