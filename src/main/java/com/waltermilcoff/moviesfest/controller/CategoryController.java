package com.waltermilcoff.moviesfest.controller;

import com.waltermilcoff.moviesfest.domain.Category;
import com.waltermilcoff.moviesfest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRespository;

    @Autowired
    public CategoryController(CategoryRepository categoryRespository) {
        this.categoryRespository = categoryRespository;
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryRespository.save(category);

    }
}
