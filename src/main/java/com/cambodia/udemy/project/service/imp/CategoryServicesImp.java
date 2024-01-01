package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.mapper.CategoryMapper;
import com.cambodia.udemy.project.repository.CategoryRepository;
import com.cambodia.udemy.project.service.CategoryServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import com.cambodia.udemy.project.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServicesImp implements CategoryServices {

    private final CategoryRepository categoryRepository;
    @Override
    public ApiResponse<String> createNewCategory(CategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.mapToCategory(request);
        Optional<?> getCategory = categoryRepository.findCategoryByCategoryName(request.getCategoryName());
        if (getCategory.isPresent()){
            return new ApiResponse<>(
                    StatusCode.STATUS_CREATED,
                    MessageResponse.MESSAGE_FAIL,
                    MessageResponse.MESSAGE_NULL
            );
        }else {
            categoryRepository.save(category);

            /* set response and return back to client */
            return new ApiResponse<>(
                    StatusCode.STATUS_CREATED,
                    MessageResponse.MESSAGE_SUCCESS,
                    MessageResponse.categoryReturnCreated()
            );
        }
    }
}
