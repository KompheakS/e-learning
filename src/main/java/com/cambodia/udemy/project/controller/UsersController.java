package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.service.imp.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private UserServiceImp userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UsersRequest userRequest){
        System.out.println("Hello world");
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }
}
