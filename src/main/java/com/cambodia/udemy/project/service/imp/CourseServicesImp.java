package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.request.CourseRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.entity.Courses;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.exception.CustomBadRequestException;
import com.cambodia.udemy.project.mapper.CourseMapper;
import com.cambodia.udemy.project.repository.CategoryRepository;
import com.cambodia.udemy.project.repository.CourseRepository;
import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.service.CourseServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServicesImp implements CourseServices {

    private final CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ApiResponse<String> createCourse(CourseRequest courseRequest) {
        Optional<Users> getUserFromDb = userRepository.findById(courseRequest.getIdUsers());
        Optional<Category> getCategoryFromDb = categoryRepository.findById(courseRequest.getCategoryId());

        if (getCategoryFromDb.isEmpty() && getUserFromDb.isEmpty()){
            log.warn("cannot create course with name {}", courseRequest.getCourseName());
            throw new CustomBadRequestException("this user or category doesn't exist!");
        }
        Courses course = courseMapper.mapToCourse(courseRequest);
        course.setCourseName(getCategoryFromDb.get().getCategoryName());
        course.setUserId(getUserFromDb.get());
        courseRepository.save(course);
        log.info("new course has been created with name {}", course.getCourseName());
        return new ApiResponse<>(HttpStatus.CREATED.value(), MessageResponse.MESSAGE_SUCCESS, MessageResponse.MESSAGE_SUCCESS);
    }
}
