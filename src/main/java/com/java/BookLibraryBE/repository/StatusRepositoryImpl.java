package com.java.BookLibraryBE.repository;

import com.java.BookLibraryBE.entity.Language;
import com.java.BookLibraryBE.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StatusRepositoryImpl implements StatusRepository {
    public static final String GET_ALL_STATUS = "SELECT * FROM BOOK_LIBRARY.STATUS;";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Status> getAllStatus() {
        return jdbcTemplate.query(GET_ALL_STATUS, (rs, rowNum) -> {
            return new Status(
                    rs.getInt("STATUS_ID"),
                    rs.getString("STATUS")
            );
        });
    }
}
