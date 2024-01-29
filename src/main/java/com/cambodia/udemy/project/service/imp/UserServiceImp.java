package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.mapper.UsersMapper;
import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.service.UserServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImp implements UserServices {
    private final UserRepository userRepository;
    private static final UsersMapper userMapper = Mappers.getMapper(UsersMapper.class);

    @Override
    public ApiResponse<String> createUser(UsersRequest usersRequest) {
        Users users = userMapper.mapToUsers(usersRequest);
        users.setJoinDate(new Timestamp(System.currentTimeMillis()));
        userRepository.save(users);
        log.info("success create user: {}", usersRequest.getUsername());
        return new ApiResponse<>( HttpStatus.CREATED.value(),MessageResponse.SUCCESS_CREATED_USER, MessageResponse.MESSAGE_SUCCESS);
    }
}
