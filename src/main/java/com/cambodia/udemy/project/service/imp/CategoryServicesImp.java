package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.ApiResponseDetails;
import com.cambodia.udemy.project.dto.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.exception.CustomBadRequestException;
import com.cambodia.udemy.project.mapper.CategoryMapper;
import com.cambodia.udemy.project.repository.CategoryRepository;
import com.cambodia.udemy.project.service.CategoryServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import com.cambodia.udemy.project.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServicesImp implements CategoryServices {

    private final CategoryRepository categoryRepository;
    @Override
    public ApiResponse<String> createNewCategory(CategoryRequest request) {
        Category category = CategoryMapper.INSTANCE.mapToCategory(request);
        Optional<?> getCategory = categoryRepository.findCategoryByCategoryName(request.getCategoryName());
        if (getCategory.isPresent()){
            throw new CustomBadRequestException("cannot create new category");
        }else {
            categoryRepository.save(category);
            return new ApiResponse<>(StatusCode.STATUS_CREATED, MessageResponse.MESSAGE_SUCCESS, MessageResponse.categoryReturnCreated());
        }
    }

    @Override
    public ApiResponseDetails<List<CategoryDto>> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = categories.stream()
                .map(CategoryMapper.INSTANCE::mapToCategoryDto)
                .collect(Collectors.toList());
        ApiResponseDetails<List<CategoryDto>> apiResponseDetails = new ApiResponseDetails<>();
        apiResponseDetails.setStatus(StatusCode.STATUS_SUCCESSFULLY);
        apiResponseDetails.setMessage(MessageResponse.MESSAGE_SUCCESS);
        apiResponseDetails.setData(categoryDto);

        return apiResponseDetails;
    }
}
