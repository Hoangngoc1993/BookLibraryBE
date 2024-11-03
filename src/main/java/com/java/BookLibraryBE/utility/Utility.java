package com.java.BookLibraryBE.utility;

import com.java.BookLibraryBE.entity.Book;

public class Utility {
    public static String searchSqlQuery(Book searchBookCondition) {
        StringBuilder searchQuery = new StringBuilder("SELECT ");
        searchQuery.append("SA.MA_SACH, SA.TEN_SACH, SA.TAC_GIA, NN.NGON_NGU, ")
                .append("TL.THE_LOAI, SA.NAM_XUAT_BAN, TT.TRANG_THAI, SA.GIOI_THIEU ")
                .append("FROM BOOK_LIBRARY.SACH SA ")
                .append("INNER JOIN BOOK_LIBRARY.NGON_NGU NN ON SA.MA_NGON_NGU = NN.MA_NGON_NGU ")
                .append("INNER JOIN BOOK_LIBRARY.TRANG_THAI TT ON SA.MA_TRANG_THAI = TT.MA_TRANG_THAI ")
                .append("INNER JOIN BOOK_LIBRARY.THE_LOAI TL ON SA.MA_THE_LOAI = TL.MA_THE_LOAI ")
                .append("WHERE SA.DELETE_FLAG = 0");
        if (searchBookCondition.getMaSach() != 0) {
            searchQuery.append(" AND SA.MA_SACH = ");
            searchQuery.append(searchBookCondition.getMaSach());
        }
        if (searchBookCondition.getTenSach() != null && !searchBookCondition.getTenSach().isEmpty()) {
            searchQuery.append(" AND SA.TEN_SACH LIKE '%");
            searchQuery.append(searchBookCondition.getTenSach());
            searchQuery.append("%'");
        }
        if (searchBookCondition.getTacGia() != null && !searchBookCondition.getTacGia().isEmpty()) {
            searchQuery.append(" AND SA.TAC_GIA LIKE '%");
            searchQuery.append(searchBookCondition.getTacGia());
            searchQuery.append("%'");
        }
        if (searchBookCondition.getNamXuatBan() != 0) {
            searchQuery.append(" AND SA.NAM_XUAT_BAN = ");
            searchQuery.append(searchBookCondition.getNamXuatBan());
        }
        String result = searchQuery.toString();
        System.out.println(result);
        return result;
    }

    public Utility() {
    }
}
