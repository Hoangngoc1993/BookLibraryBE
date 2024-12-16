package com.java.BookLibraryBE.controller;

import com.java.BookLibraryBE.entity.Category;
import com.java.BookLibraryBE.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }
}
