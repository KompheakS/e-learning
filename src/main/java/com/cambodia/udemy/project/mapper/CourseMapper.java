package com.cambodia.udemy.project.mapper;

import com.cambodia.udemy.project.dto.request.CourseRequest;
import com.cambodia.udemy.project.entity.Courses;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Courses mapToCourse(CourseRequest courseRequest);
}
