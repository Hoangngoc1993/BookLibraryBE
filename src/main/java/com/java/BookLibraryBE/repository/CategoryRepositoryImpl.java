package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Category;
import com.java.BookLibraryBE.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM BOOK_LIBRARY.CATEGORY;";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, (rs, rowNum) -> {
            return new Category(
                    rs.getInt("CATEGORY_ID"),
                    rs.getString("CATEGORY")
            );
        });
    }
}
