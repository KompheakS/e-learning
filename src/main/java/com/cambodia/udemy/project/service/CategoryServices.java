package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.dto.response.ApiResponseDetails;
import com.cambodia.udemy.project.dto.response.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryServices {
    ApiResponse<String> createNewCategory(CategoryRequest request);
    ApiResponseDetails<List<CategoryDto>> getAllCategory();
    ApiResponse<String> deleteCategoryById(Long id);
}
