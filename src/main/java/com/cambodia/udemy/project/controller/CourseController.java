package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.request.CourseRequest;
import com.cambodia.udemy.project.service.CourseServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseServices courseServices;

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestBody CourseRequest courseRequest){
        return new ResponseEntity<>(courseServices.createCourse(courseRequest), HttpStatus.CREATED);
    }
}
