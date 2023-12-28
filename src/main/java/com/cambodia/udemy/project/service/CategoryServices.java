package com.cambodia.udemy.project.service;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.request.CategoryRequest;

public interface CategoryServices {
    ApiResponse<String> createNewCategory(CategoryRequest request);
}
