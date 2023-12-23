package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.service.imp.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsersController {
    private UserServiceImp userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Users users){
        /*userService.addUserToDb(users);*/

        return ResponseEntity.ok("success");
    }
}
