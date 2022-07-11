package com.danmag.pcpartsstore.service.controller;

import com.danmag.pcpartsstore.service.model.Category;
import com.danmag.pcpartsstore.service.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
}
