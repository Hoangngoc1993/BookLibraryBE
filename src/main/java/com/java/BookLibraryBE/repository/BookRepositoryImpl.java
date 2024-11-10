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
    public static final String INSERT_BOOK_QUERY = "INSERT INTO BOOK_LIBRARY.SACH "
            + "(MA_SACH, TEN_SACH, TAC_GIA, NAM_XUAT_BAN, MA_NGON_NGU, MA_THE_LOAI, MA_TRANG_THAI, GIOI_THIEU, DELETE_FLAG, NGAY_GIO_CAP_NHAT)"
            + "VALUES(?,?,?,?,?,?,?,?,?,SYSDATE(6))";
    public static final String UPDATE_BOOK_QUERY = "UPDATE BOOK_LIBRARY.SACH "
            + "SET TEN_SACH = ?, TAC_GIA = ?, NAM_XUAT_BAN = ?, "
            + "MA_NGON_NGU = ?, MA_THE_LOAI = ?, MA_TRANG_THAI = ?,"
            + "GIOI_THIEU = ?, NGAY_GIO_CAP_NHAT = SYSDATE(6) WHERE MA_SACH = ?";
    public static final String DELETE_BOOK_BY_ID_QUERY = "UPDATE BOOK_LIBRARY.SACH "
            + "SET DELETE_FLAG = 1, NGAY_GIO_CAP_NHAT = SYSDATE(6) WHERE MA_SACH = ?";
    public static final String GET_BOOKS_BY_ID_QUERY = "SELECT * FROM BOOK_LIBRARY.SACH "
            + "WHERE DELETE_FLAG = 0 AND MA_SACH = ?";
    public static String GET_BOOKS_BY_CONDITION_QUERY = "";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public String saveBook(BookRequest book) {
        System.out.println("Add Book - RepositoryIpml");
        jdbcTemplate.update(
                INSERT_BOOK_QUERY,
                book.getMaSach(),
                book.getTenSach(),
                book.getTacGia(),
                book.getNamXuatBan(),
                book.getMaNgonNgu(),
                book.getMaTheLoai(),
                book.getMaTrangThai(),
                book.getGioiThieu(),
                0);
        return "Book has been created";
    }

    @Override
    public String updateBook(BookRequest book) {
        System.out.println("Update Book - RepositoryIpml");
        jdbcTemplate.update(
                UPDATE_BOOK_QUERY,
                book.getTenSach(),
                book.getTacGia(),
                book.getNamXuatBan(),
                book.getMaNgonNgu(),
                book.getMaTheLoai(),
                book.getMaTrangThai(),
                book.getGioiThieu(),
                book.getMaSach()
        );
        return "Book has been updated";
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
                    rs.getInt("ma_sach"),
                    rs.getString("ten_sach"),
                    rs.getString("tac_gia"),
                    rs.getInt("nam_xuat_ban"),
                    rs.getInt("ma_ngon_ngu"),
                    rs.getInt("ma_the_loai"),
                    rs.getInt("ma_trang_thai"),
                    rs.getString("gioi_thieu"),
                    rs.getTimestamp("ngay_gio_cap_nhat").toLocalDateTime(),
                    0
            );
        });
    }

    @Override
    public List<BookResponse> getBooksByCondition(BookRequest searchBookCondition) {
        GET_BOOKS_BY_CONDITION_QUERY = Utility.searchSqlQuery(searchBookCondition);
        return jdbcTemplate.query(GET_BOOKS_BY_CONDITION_QUERY, (rs, rowNum) -> {
            return new BookResponse(
                    rs.getInt("MA_SACH"),
                    rs.getString("TEN_SACH"),
                    rs.getString("TAC_GIA"),
                    rs.getInt("NAM_XUAT_BAN"),
                    rs.getString("NGON_NGU"),
                    rs.getString("THE_LOAI"),
                    rs.getString("TRANG_THAI"),
                    rs.getString("GIOI_THIEU")
            );
        });
    }
}
