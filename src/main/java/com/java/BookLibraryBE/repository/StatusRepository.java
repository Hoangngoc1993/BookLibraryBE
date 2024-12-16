package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Category;
import com.java.BookLibraryBE.entity.Status;

import java.util.List;

public interface StatusRepository {
    List<Status> getAllStatus();
}
