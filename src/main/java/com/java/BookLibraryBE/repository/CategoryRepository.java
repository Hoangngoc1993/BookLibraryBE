package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAllCategories();
}
