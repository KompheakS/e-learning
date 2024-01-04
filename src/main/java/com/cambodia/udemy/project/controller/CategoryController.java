package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.ApiResponseDetails;
import com.cambodia.udemy.project.dto.CategoryDto;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.service.CategoryServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryServices categoryServices;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> createNewCategory(@RequestBody CategoryRequest categoryRequest){
        ApiResponse<String> response = categoryServices.createNewCategory(categoryRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/gets")
    public ResponseEntity<?> getAllCategory(){
        ApiResponseDetails<List<CategoryDto>> responseDetails = categoryServices.getAllCategory();
        return ResponseEntity.ok(responseDetails);
    }
}
