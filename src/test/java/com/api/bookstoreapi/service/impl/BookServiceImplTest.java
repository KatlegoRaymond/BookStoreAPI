package com.api.bookstoreapi.service.impl;

import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.repository.BookRepository;
import com.api.bookstoreapi.service.BookService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;
    private BookService bookService;
    private AutoCloseable autoCloseable;
    private Book book;

    /**
     * Set up the test environment before each test method execution.
     */
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
        book = new Book("1", "Amazon", "J. Doe", 10.50);
    }

    /**
     * Clean up the test environment after each test method execution.
     */
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    /**
     * Test case to verify creating a book.
     */
    @Test
    void testCreateBook() {
        // Mocking the behavior of bookRepository's save method
        when(bookRepository.save(book)).thenReturn(book);

        // Asserting that the book is created successfully
        assertThat(bookService.createBook(book)).isEqualTo("Book Created Successfully");
    }
    
    /**
     * Test case to verify getting books by vendor name.
     */
    @Test
    void testGetByVendorName() {
        // Mocking the behavior of bookRepository's findByBookTitle method
        when(bookRepository.findByBookTitle("Amazon"))
                .thenReturn(new ArrayList<>(Collections.singletonList(book)));

        // Asserting that the book with the vendor name "Amazon" is returned
        assertThat(bookService.getByBookTitle("Amazon").get(0).getBookId()).isEqualTo(book.getBookId());
    }

    /**
     * Test case to verify getting all books.
     */
    @Test
    void testGetAllBooks() {
        // Mocking the behavior of bookRepository's findAll method
        when(bookRepository.findAll())
                .thenReturn(new ArrayList<>(Collections.singletonList(book)));

        // Asserting that all books are returned
        assertThat(bookService.getAllBooks().get(0).getBookPrice()).isEqualTo(book.getBookPrice());
    }

    /**
     * Test case to verify updating a book.
     */
    @Test
    void testUpdateBook() {
        // Mocking the behavior of bookRepository's save method
        when(bookRepository.save(book)).thenReturn(book);

        // Asserting that the book is updated successfully
        assertThat(bookService.updateBook(book)).isEqualTo("Book Updated Successfully");
    }

    /**
     * Test case to verify deleting a book.
     */
    @Test
    void testDeleteBook() {
        // Mocking the behavior of bookRepository's deleteById method
        doNothing().when(bookRepository).deleteById(any());

        // Asserting that the book is deleted successfully
        assertThat(bookService.deleteBook("1")).isEqualTo("Book Deleted Successfully");
    }

    /**
     * Test case to verify getting a book by its ID.
     */
    @Test
    void testGetBook() {
        // Mocking the behavior of bookRepository's findById method
        when(bookRepository.findById("1")).thenReturn(Optional.ofNullable(book));

        // Asserting that the correct book is returned
        assertThat(bookService.getBook("1").getBookTitle()).isEqualTo(book.getBookTitle());
    }

    
}
