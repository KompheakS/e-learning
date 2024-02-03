package com.cambodia.udemy.project.mapper;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.response.UsersResponse;
import com.cambodia.udemy.project.entity.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UsersMapper {
    Users mapToUsers(UsersRequest usersRequest);
    UsersResponse mapToUsersResponse(Users users);
}