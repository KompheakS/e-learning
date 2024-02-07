package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.request.CourseRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;

public interface CourseServices {
    ApiResponse<String> createCourse(CourseRequest courseRequest);
    ApiResponse<?> viewAllCourse();
}
