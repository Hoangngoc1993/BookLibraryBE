package com.java.BookLibraryBE.entity;

public class BookResponse {
    public int book_id;
    public String book_name;
    public String author;
    public int publication_year;
    public String language;
    public String category;
    public String status;
    public String introducion;

    public BookResponse() {
    }

    public BookResponse(int book_id, String book_name, String author, int publication_year, String language, String category, String status, String introducion) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.publication_year = publication_year;
        this.language = language;
        this.category = category;
        this.status = status;
        this.introducion = introducion;
    }
}
