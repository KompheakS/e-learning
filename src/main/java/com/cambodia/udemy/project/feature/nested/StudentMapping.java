package com.cambodia.udemy.project.feature.nested;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapping {
    @Mapping(target = "subject", source = "subject.name")
    StudentTwo getModelFromStudentEntityTwo(StudentEntityTwo studentEntityTwo);
}
