package com.danmag.pcpartsstore.service.service;

import com.danmag.pcpartsstore.service.model.Category;
import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory() {
        return (List<Category>) categoryRepository.findAll();
    }
}
