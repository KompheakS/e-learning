package com.cambodia.udemy.project.feature;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {

    @Mapping(target = "className", source = "classVal")
    Student getModelFromEntity(StudentEntity studentEntity);

}
