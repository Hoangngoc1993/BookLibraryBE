package com.java.BookLibraryBE.controller;

import com.java.BookLibraryBE.entity.Category;
import com.java.BookLibraryBE.entity.Status;
import com.java.BookLibraryBE.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;
    @GetMapping("/status")
    public List<Status> getAllStatus(){
        return statusRepository.getAllStatus();
    }
}
