package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserServices {
    private final UserRepository userRepository;
}
