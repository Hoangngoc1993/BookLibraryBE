package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookRequest;
import com.java.BookLibraryBE.entity.BookResponse;

import java.util.List;

public interface BookRepository {
    String saveBook(BookRequest book);
    String updateBook(BookRequest book);
    String deleteById(int id);
    Book getBookById(int id);
    List<BookResponse> getBooksByCondition(BookRequest searchBookCondition);
}
