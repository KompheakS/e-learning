package com.cambodia.udemy.project.mapper.manual;

import com.cambodia.udemy.project.dto.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.entity.Category;
import lombok.Data;
import org.mapstruct.factory.Mappers;

@Data
public class CategoryMapper {
    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public Category mapToCategory(CategoryRequest categoryRequest){
        Category category = new Category();

        category.setCategoryName(categoryRequest.getCategoryName());
        return category;
    }

    public CategoryDto mapToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
}
