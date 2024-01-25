package com.cambodia.udemy.project.mapper;

import com.cambodia.udemy.project.dto.response.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapping {

    Category mapToCategory(CategoryRequest request);
    CategoryDto mapToCategoryDto(Category category);
}
