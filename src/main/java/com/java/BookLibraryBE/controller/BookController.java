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
            @RequestParam(value = "maSach", defaultValue = "0") int maSach,
            @RequestParam(value = "tenSach", defaultValue = "") String tenSach,
            @RequestParam(value = "tacGia", defaultValue = "") String tacGia,
            @RequestParam(value = "namXuatBan", defaultValue = "0") int namXuatBan,
            @RequestParam(value = "maNgonNgu", defaultValue = "0") int maNgonNgu,
            @RequestParam(value = "maTheLoai", defaultValue = "0") int maTheLoai,
            @RequestParam(value = "maTrangThai", defaultValue = "0") int maTrangThai
    ) {
        BookRequest searchCondition = new BookRequest(maSach, tenSach, tacGia, namXuatBan, maNgonNgu, maTheLoai, maTrangThai, "");
        return bookRepository.getBooksByCondition(searchCondition);
    }

    @PutMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        System.out.println("Delete Book - Controller");
        return bookRepository.deleteById(id);
    }
}
