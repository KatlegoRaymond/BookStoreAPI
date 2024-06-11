package com.api.bookstoreapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Book class.
 */
public class BookTest {

    /**
     * Test case to verify the constructor and getters of the Book class.
     */
    @Test
    public void testBookConstructorAndGetters() {
        // Create a book object with sample data
        Book book = new Book("1", "Title", "Author", 29.99);
        
        // Assert that the getters return the correct values
        assertEquals("1", book.getBookId());
        assertEquals("Title", book.getBookTitle());
        assertEquals("Author", book.getBookAuthor());
        assertEquals(29.99, book.getBookPrice());
    }

    /**
     * Test case to verify the setters of the Book class.
     */
    @Test
    public void testBookSetters() {
        // Create a new book object
        Book book = new Book();
        
        // Set values using setters
        book.setBookId("1");
        book.setBookTitle("Title");
        book.setBookAuthor("Author");
        book.setBookPrice(29.99);
        
        // Assert that the getters return the values set by the setters
        assertEquals("1", book.getBookId());
        assertEquals("Title", book.getBookTitle());
        assertEquals("Author", book.getBookAuthor());
        assertEquals(29.99, book.getBookPrice());
    }
}
