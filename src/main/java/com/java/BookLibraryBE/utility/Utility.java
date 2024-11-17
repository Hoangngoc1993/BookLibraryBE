package com.java.BookLibraryBE.utility;

import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookRequest;

public class Utility {
    public static String searchSqlQuery(BookRequest searchBookCondition) {
        StringBuilder searchQuery = new StringBuilder("SELECT ");
        searchQuery.append("SA.BOOK_ID, SA.BOOK_NAME, SA.AUTHOR, NN.LANGUAGE, ")
                .append("TL.CATEGORY, SA.PUBLICATION_YEAR, TT.STATUS, SA.INTRODUCION ")
                .append("FROM BOOK_LIBRARY.BOOK SA ")
                .append("INNER JOIN BOOK_LIBRARY.LANGUAGE NN ON SA.LANGUAGE_ID = NN.LANGUAGE_ID ")
                .append("INNER JOIN BOOK_LIBRARY.STATUS TT ON SA.STATUS_ID = TT.STATUS_ID ")
                .append("INNER JOIN BOOK_LIBRARY.CATEGORY TL ON SA.CATEGORY_ID = TL.CATEGORY_ID ")
                .append("WHERE SA.DELETE_FLAG = 0");
        if (searchBookCondition.getBook_id() != 0) {
            searchQuery.append(" AND SA.BOOK_ID = ");
            searchQuery.append(searchBookCondition.getBook_id());
        }
        if (searchBookCondition.getBook_name() != null && !searchBookCondition.getBook_name().isEmpty()) {
            searchQuery.append(" AND SA.BOOK_NAME LIKE '%");
            searchQuery.append(searchBookCondition.getBook_name());
            searchQuery.append("%'");
        }
        if (searchBookCondition.getAuthor() != null && !searchBookCondition.getAuthor().isEmpty()) {
            searchQuery.append(" AND SA.AUTHOR LIKE '%");
            searchQuery.append(searchBookCondition.getAuthor());
            searchQuery.append("%'");
        }
        if (searchBookCondition.getPublication_year() != 0) {
            searchQuery.append(" AND SA.PUBLICATION_YEAR = ");
            searchQuery.append(searchBookCondition.getPublication_year());
        }
        if (searchBookCondition.getLanguage_id() != 0) {
            searchQuery.append(" AND SA.LANGUAGE_ID = ");
            searchQuery.append(searchBookCondition.getLanguage_id());
        }
        if (searchBookCondition.getCategory_id() != 0) {
            searchQuery.append(" AND SA.CATEGORY_ID = ");
            searchQuery.append(searchBookCondition.getCategory_id());
        }
        if (searchBookCondition.getStatus_id() > -1) {
            searchQuery.append(" AND SA.STATUS_ID = ");
            searchQuery.append(searchBookCondition.getStatus_id());
        }
        searchQuery.append(" ORDER BY SA.BOOK_ID");
        String result = searchQuery.toString();
        System.out.println(result);
        return result;
    }

    public Utility() {
    }
}
