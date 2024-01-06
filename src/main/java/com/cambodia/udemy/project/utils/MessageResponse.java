package com.cambodia.udemy.project.utils;

import lombok.Data;

@Data
public class MessageResponse {
    public static final String MESSAGE_SUCCESS = "success";
    public static final String MESSAGE_FAIL = "fail";
    public static final String MESSAGE_NULL = "null";

    public static String categoryReturnCreated(){
        return "New Category Was Created!";
    }
}
