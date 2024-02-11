package com.cambodia.udemy.project;

import com.cambodia.udemy.project.entity.Courses;
import com.cambodia.udemy.project.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testGetCourse(){
        Optional<Courses> courses = courseRepository.findByCourseName("Spring Boot");
        System.out.println(courses.toString());
    }

}
