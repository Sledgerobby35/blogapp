package com.codeup.blogapp.web;

import com.codeup.blogapp.data.category.Category;
import com.codeup.blogapp.data.category.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json")
public class CategoriesController {

    private final CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    private List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    private Category getCategoryById(@PathVariable Long id){
        return categoryRepository.getById(id);
    }
}

