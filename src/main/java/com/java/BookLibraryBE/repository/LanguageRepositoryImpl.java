package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.BookResponse;
import com.java.BookLibraryBE.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository{
    public static final String GET_ALL_LANGUAGES = "SELECT * FROM BOOK_LIBRARY.LANGUAGE;";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Language> getAllLanguages() {
        return jdbcTemplate.query(GET_ALL_LANGUAGES, (rs, rowNum) -> {
            return new Language(
                    rs.getInt("LANGUAGE_ID"),
                    rs.getString("LANGUAGE")
            );
        });
    }
}
