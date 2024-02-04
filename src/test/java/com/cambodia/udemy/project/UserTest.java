package com.cambodia.udemy.project;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    private final UsersMapper usersMapper = Mappers.getMapper(UsersMapper.class);

    @Test
    void testCreateUser(){
        // Given
        UsersRequest usersRequest = new UsersRequest();
        usersRequest.setUsername("test.test");
        usersRequest.setPassword("test@1234");
        usersRequest.setPhoneNumber("0000000000");
        usersRequest.setEmail("test@gmail.com");
        usersRequest.setGender("MALE");
        usersRequest.setDateOfBirth(LocalDate.of(2003, 2, 15));

        Users user = usersMapper.mapToUsers(usersRequest);
        user.setJoinDate(LocalDate.now());

        // When
        Users usersTest = userRepository.save(user);

        // Then
        assertNotNull(usersTest);
    }

    @Test
    void testGetAllUsers(){
        // Given

    }
}
