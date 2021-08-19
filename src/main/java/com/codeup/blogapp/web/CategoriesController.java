package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "application/json")
public class CategoriesController {

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1l, "Spring Boot"));
    }};


    @GetMapping
    private List<Category> getCategories(){
        return categories;
    }
}

