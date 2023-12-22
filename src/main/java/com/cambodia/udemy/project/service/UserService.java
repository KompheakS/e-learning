package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
