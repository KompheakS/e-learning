package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.entity.Users;

public interface UserServices {
    ApiResponse<String> createUser(UsersRequest usersRequest);
}
