package com.java.BookLibraryBE.entity;

import java.time.LocalDateTime;

public class BookRequest {
    public int book_id;
    public String book_name;
    public String author;
    public int publication_year;
    public int language_id;
    public int category_id;
    public int status_id;
    public String introducion;
    public LocalDateTime update_time;

    public BookRequest() {
    }


    public BookRequest(int book_id, String book_name, String author, int publication_year, int language_id, int category_id, int status_id, String introducion, LocalDateTime update_time) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.publication_year = publication_year;
        this.language_id = language_id;
        this.category_id = category_id;
        this.status_id = status_id;
        this.introducion = introducion;
        this.update_time = update_time;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getIntroducion() {
        return introducion;
    }

    public void setIntroducion(String introducion) {
        this.introducion = introducion;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
=======
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getIntroducion() {
        return introducion;
    }

    public void setIntroducion(String introducion) {
        this.introducion = introducion;
    }
}
