package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookDTO;

import java.util.List;

public interface BookRepository {
    Book saveBook(Book book);
    Book updateBook(Book book);
    String deleteById(int maSach);
    List<BookDTO> getBooksByCondition(Book searchBookCondition);
}
