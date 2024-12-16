package com.java.BookLibraryBE.controller;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.BookLibraryBE.entity.Book;
import com.java.BookLibraryBE.entity.BookRequest;
import com.java.BookLibraryBE.entity.BookResponse;
import com.java.BookLibraryBE.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testAddBook() throws Exception {
        BookRequest bookRequest = new BookRequest(
                100090,
                "Đại Việt Sử Ký Toàn Thư",
                "Ngô Sĩ Liên",
                2007,
                1,
                4,
                1,
                "ĐVSKTT là bộ chính sử Việt Nam xưa nhất",
                null
        );

        // Json data of bookRequest
        ObjectMapper objectMapper = new ObjectMapper();
        String bookRequestJson = objectMapper.writeValueAsString(bookRequest);

        String mockResponse = "Book has been created";
        Mockito.when(bookRepository.saveBook(Mockito.any(BookRequest.class))).thenReturn(mockResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookRequestJson))
                .andExpect(status().isOk())
                .andExpect(content().string(mockResponse));
    }

    @Test
    public void testUpdateBook() throws Exception {
        String updateTimeString = "2024-12-08 21:43:15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime updateTime = LocalDateTime.parse(updateTimeString, formatter);
        BookRequest bookRequest = new BookRequest(
                100002,
                "Đại Việt Sử Ký Toàn Thư",
                "Ngô Sĩ Liên",
                2008,
                1,
                4,
                1,
                "ĐVSKTT là bộ chính sử Việt Nam xưa nhất",
                updateTime
        );
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String bookRequestJson = objectMapper.writeValueAsString(bookRequest);
        String mockResponse = "Updated successfully";
        Mockito.when(bookRepository.updateBook(Mockito.any(BookRequest.class))).thenReturn(mockResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookRequestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookById() throws Exception {
        String updateTimeString = "2024-11-07 07:19:19";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime updateTime = LocalDateTime.parse(updateTimeString, formatter);
        // Mock data from repository
        Book mockBooks = new Book(
                100002,
                "Đại Việt Sử Ký Toàn Thư",
                "Ngô Sĩ Liên",
                2007,
                1,
                4,
                1,
                "ĐVSKTT là bộ chính sử Việt Nam xưa nhất",
                updateTime,
                0
        );
        Mockito.when(bookRepository.getBookById(100002)).thenReturn(mockBooks);

        // send request check result
        mockMvc.perform(get("/book/100002")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.book_id").value(100002))
                .andExpect(jsonPath("$.book_name").value("Đại Việt Sử Ký Toàn Thư"));
    }

    @Test
    public void testGetBooksByCondition() throws Exception {
        // Mock data from repository
        List<BookResponse> mockBooks = Arrays.asList(
                new BookResponse(
                        100002,
                        "Đại Việt Sử Ký Toàn Thư",
                        "Ngô Sĩ Liên",
                        2007,
                        "Việt",
                        "Lịch sử",
                        "Có thể mượn",
                        "ĐVSKTT là bộ chính sử Việt Nam xưa nhất"
                )
        );
        Mockito.when(bookRepository.getBooksByCondition(any(BookRequest.class))).thenReturn(mockBooks);

        // send request check result
        mockMvc.perform(get("/books")
                        .param("bookId", "100002")
                        .param("bookName", "Đại Việt Sử Ký Toàn Thư")
                        .param("author", "Ngô Sĩ Liên")
                        .param("publicationYear", "2007")
                        .param("languageId", "1")
                        .param("categoryId", "4")
                        .param("statusId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1))) // list has 1 element
                .andExpect(jsonPath("$[0].book_id", is(100002))) // see first element
                .andExpect(jsonPath("$[0].book_name", is("Đại Việt Sử Ký Toàn Thư")));
    }

    @Test
    public void testDeleteBookById() throws Exception {
        String mockResponse = "Book has been deleted";
        Mockito.when(bookRepository.deleteById(100002)).thenReturn(mockResponse);
        mockMvc.perform(MockMvcRequestBuilders.put("/deletebook/100002")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(mockResponse));
    }
}
