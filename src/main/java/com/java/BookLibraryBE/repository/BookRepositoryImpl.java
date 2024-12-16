package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookRequest;
import com.java.BookLibraryBE.entity.BookResponse;
import com.java.BookLibraryBE.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    public static final String INSERT_BOOK_QUERY = "INSERT INTO BOOK_LIBRARY.BOOK "
            + "(BOOK_ID, BOOK_NAME, AUTHOR, PUBLICATION_YEAR, LANGUAGE_ID, CATEGORY_ID, STATUS_ID, INTRODUCION, DELETE_FLAG, UPDATE_TIME)"
            + "VALUES(?,?,?,?,?,?,?,?,?,SYSDATE(6))";
    public static final String UPDATE_BOOK_QUERY = "UPDATE BOOK_LIBRARY.BOOK "
            + "SET BOOK_NAME = ?, AUTHOR = ?, PUBLICATION_YEAR = ?, "
            + "LANGUAGE_ID = ?, CATEGORY_ID = ?, STATUS_ID = ?, "
            + "INTRODUCION = ?, UPDATE_TIME = SYSDATE(6) WHERE BOOK_ID = ?";
    public static final String DELETE_BOOK_BY_ID_QUERY = "UPDATE BOOK_LIBRARY.BOOK "
            + "SET DELETE_FLAG = 1, UPDATE_TIME = SYSDATE(6) WHERE BOOK_ID = ?";
    public static final String GET_BOOKS_BY_ID_QUERY = "SELECT * FROM BOOK_LIBRARY.BOOK "
            + "WHERE DELETE_FLAG = 0 AND BOOK_ID = ?";
    public static String GET_BOOKS_BY_CONDITION_QUERY = "";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public String saveBook(BookRequest book) {
        System.out.println("Add Book - RepositoryIpml");
        jdbcTemplate.update(
                INSERT_BOOK_QUERY,
                book.getBook_id(),
                book.getBook_name(),
                book.getAuthor(),
                book.getPublication_year(),
                book.getLanguage_id(),
                book.getCategory_id(),
                book.getStatus_id(),
                book.getIntroducion(),
                0);
        return "Book has been created";
    }

    @Override
    public String updateBook(BookRequest book) {
        System.out.println("Update Book - RepositoryIpml");
        String CHECK_CONFLICT = "SELECT COUNT(*) FROM BOOK WHERE BOOK_ID = ? AND UPDATE_TIME = ?";
        int count = jdbcTemplate.queryForObject(
                CHECK_CONFLICT,
                new Object[]{book.getBook_id(), book.getUpdate_time()},
                Integer.class
        );
        if (count > 0){
            jdbcTemplate.update(
                    UPDATE_BOOK_QUERY,
                    book.getBook_name(),
                    book.getAuthor(),
                    book.getPublication_year(),
                    book.getLanguage_id(),
                    book.getCategory_id(),
                    book.getStatus_id(),
                    book.getIntroducion(),
                    book.getBook_id()
            );
            return "Updated successfully";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String deleteById(int id) {
        System.out.println("Delete Book - RepositoryIpml");
        jdbcTemplate.update(DELETE_BOOK_BY_ID_QUERY, id);
        return "Book has been deleted";
    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(GET_BOOKS_BY_ID_QUERY, new Object[]{id}, (rs, rowNum) -> {
            return new Book(
                    rs.getInt("BOOK_ID"),
                    rs.getString("BOOK_NAME"),
                    rs.getString("AUTHOR"),
                    rs.getInt("PUBLICATION_YEAR"),
                    rs.getInt("LANGUAGE_ID"),
                    rs.getInt("CATEGORY_ID"),
                    rs.getInt("STATUS_ID"),
                    rs.getString("INTRODUCION"),
                    rs.getTimestamp("UPDATE_TIME").toLocalDateTime(),
                    0
            );
        });
    }

    @Override
    public List<BookResponse> getBooksByCondition(BookRequest searchBookCondition) {
        GET_BOOKS_BY_CONDITION_QUERY = Utility.searchSqlQuery(searchBookCondition);
        return jdbcTemplate.query(GET_BOOKS_BY_CONDITION_QUERY, (rs, rowNum) -> {
            return new BookResponse(
                    rs.getInt("BOOK_ID"),
                    rs.getString("BOOK_NAME"),
                    rs.getString("AUTHOR"),
                    rs.getInt("PUBLICATION_YEAR"),
                    rs.getString("LANGUAGE"),
                    rs.getString("CATEGORY"),
                    rs.getString("STATUS"),
                    rs.getString("INTRODUCION")
            );
        });
    }
}
