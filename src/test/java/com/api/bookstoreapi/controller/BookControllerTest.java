package com.api.bookstoreapi.controller;

import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for the BookController class.
 */
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private Book book1;
    private Book book2;
    private List<Book> bookList = new ArrayList<>();

    /**
     * Setup method to initialize mock objects and test data before each test method.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book1 = new Book("1", "Intro to Prog", "J. Doe", 29.99);
        book2 = new Book("2", "Java OOP v1", "K. Doe", 539.99);
        bookList.add(book1);
        bookList.add(book2);
    }

    /**
     * Teardown method to clear test data after each test method.
     */
    @AfterEach
    void tearDown() {
        bookList.clear();
    }

    /**
     * Test case for retrieving book details by book ID.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testGetBookDetails() throws Exception {
        when(bookService.getBook("1")).thenReturn(book1);
        this.mockMvc.perform(get("/Book/"+"1")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test case for retrieving all book details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testGetAllBookDetails() throws Exception {
        when(bookService.getAllBooks()).thenReturn(bookList);
        this.mockMvc.perform(get("/Book/"))
                .andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test case for creating book details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testCreateBookDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(book1);

        this.mockMvc.perform(post("/Book/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Book Created Successfully"));

    }

    /**
     * Test case for updating book details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testUpdateBookDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(book1);

        this.mockMvc.perform(put("/Book/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Book Updated Successfully"));

    }

    /**
     * Test case for deleting book details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testDeleteBookDetails() throws Exception {
        when(bookService.deleteBook("1")).thenReturn("Book Deleted Successfully");

        this.mockMvc.perform(delete("/Book/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Book Deleted Successfully"));

    }
}
