package com.java.BookLibraryBE.controller;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookDTO;
import com.java.BookLibraryBE.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        System.out.println("Add Book - Controller");
        return bookRepository.saveBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        System.out.println("Update Book - Controller");
        return bookRepository.updateBook(book);
    }

    @GetMapping("/books")
    public List<BookDTO> getBooksByCondition(@RequestBody Book searchCondition) {
        return bookRepository.getBooksByCondition(searchCondition);
    }

    @PutMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        System.out.println("Delete Book - Controller");
        return bookRepository.deleteById(id);
    }
}
