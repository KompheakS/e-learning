package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.ApiResponseDetails;
import com.cambodia.udemy.project.dto.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryServices {
    ApiResponse<String> createNewCategory(CategoryRequest request);
    ApiResponseDetails<List<CategoryDto>> getAllCategory();
    ApiResponse<String> deleteCategoryById(Long id);
}
