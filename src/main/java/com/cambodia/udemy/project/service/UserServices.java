package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface UserServices {
    ApiResponse<String> createUser(UsersRequest usersRequest) throws MessagingException, UnsupportedEncodingException;
    ApiResponse<?> getAllUser();
}