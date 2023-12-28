package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.mapper.CategoryMapper;
import com.cambodia.udemy.project.repository.CategoryRepository;
import com.cambodia.udemy.project.service.CategoryServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServicesImp implements CategoryServices {

    private final CategoryRepository categoryRepository;
    @Override
    public ApiResponse<String> createNewCategory(CategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.mapToCategory(request);

        categoryRepository.save(category);

        /* set response and return back to client */
        return new ApiResponse<>(
                200,
                "success",
                "new category was created"
        );
    }
}
