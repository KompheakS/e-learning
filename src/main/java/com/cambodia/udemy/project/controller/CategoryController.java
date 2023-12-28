package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.ApiResponse;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.service.CategoryServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
