package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.request.VerifyRequest;
import com.cambodia.udemy.project.service.UserServices;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private UserServices userService;

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UsersRequest userRequest) throws MessagingException, UnsupportedEncodingException {
        return new ResponseEntity<>(userService.userRegister(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/views")
    public ResponseEntity<?> viewAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyEmail(@RequestBody VerifyRequest request){
        return new ResponseEntity<>(userService.emailVerify(request), HttpStatus.OK);
    }
}
