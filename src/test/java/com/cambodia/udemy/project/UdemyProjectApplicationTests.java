package com.cambodia.udemy.project;

import com.cambodia.udemy.project.entity.Category;
import com.cambodia.udemy.project.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UdemyProjectApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateNewCategory(){
		// given
		Category category = new Category();
		category.setCategoryName("Test Category 4");
		// when
		Category result = categoryRepository.save(category);
		// then
		assertNotNull(result);
	}

	@Test
	void testCategoryGetAllService(){
		// given
		// when
		List<Category> category = categoryRepository.findAll();
		// then
		assertFalse(category.isEmpty());
	}

}
