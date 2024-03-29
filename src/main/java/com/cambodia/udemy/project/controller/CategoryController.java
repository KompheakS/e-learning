package com.cambodia.udemy.project.controller;

import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.dto.request.CategoryRequest;
import com.cambodia.udemy.project.service.CategoryServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private CategoryServices categoryServices;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> createNewCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryServices.createNewCategory(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/gets")
    public ResponseEntity<?> getAllCategory(){
        log.info("get all the category successfully!");
        return new ResponseEntity<>(categoryServices.getAllCategory(), HttpStatus.OK);
    }

    @PostMapping("{id}/delete")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        return new ResponseEntity<>(categoryServices.deleteCategoryById(id), HttpStatus.OK);
    }
}
