package com.java.BookLibraryBE.controller;

import com.java.BookLibraryBE.entity.Language;
import com.java.BookLibraryBE.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;
    @GetMapping("/languages")
    public List<Language> getAllLanguages(){
        return languageRepository.getAllLanguages();
    }
}
