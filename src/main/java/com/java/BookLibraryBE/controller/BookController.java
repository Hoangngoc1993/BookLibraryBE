package com.java.BookLibraryBE.controller;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookRequest;
import com.java.BookLibraryBE.entity.BookResponse;
import com.java.BookLibraryBE.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @PostMapping("/book")
    public String addBook(@RequestBody BookRequest book) {
        System.out.println("Add Book - Controller");
        return bookRepository.saveBook(book);
    }

    @PutMapping("/book")
    public String updateBook(@RequestBody BookRequest book) {
        System.out.println("Update Book - Controller");
        return bookRepository.updateBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookRepository.getBookById(id);
    }

    @GetMapping("/books")
    public List<BookResponse> getBooksByCondition(
            @RequestParam(value = "bookId", defaultValue = "0") int bookId,
            @RequestParam(value = "bookName", defaultValue = "") String bookName,
            @RequestParam(value = "author", defaultValue = "") String author,
            @RequestParam(value = "publicationYear", defaultValue = "0") int publicationYear,
            @RequestParam(value = "languageId", defaultValue = "0") int languageId,
            @RequestParam(value = "categoryId", defaultValue = "0") int categoryId,
            @RequestParam(value = "statusId", defaultValue = "0") int statusId
    ) {
        BookRequest searchCondition = new BookRequest(bookId, bookName, author, publicationYear, languageId, categoryId, statusId, "", null);
        return bookRepository.getBooksByCondition(searchCondition);
    }

    @PutMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        System.out.println("Delete Book - Controller");
        return bookRepository.deleteById(id);
    }
}
