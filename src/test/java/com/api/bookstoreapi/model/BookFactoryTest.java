package com.api.bookstoreapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SuppressWarnings("unused")
public class BookFactoryTest {

    @Test
    void testCreateBook() {
        // Given
        String bookId = "1";
        String bookTitle = "Sample Book";
        String bookAuthor = "John Doe";
        double bookPrice = 19.99;

        // When
        Book book = BookFactory.createBook(bookId, bookTitle, bookAuthor, bookPrice);

        // Then
        assertEquals(bookId, book.getBookId());
        assertEquals(bookTitle, book.getBookTitle());
        assertEquals(bookAuthor, book.getBookAuthor());
        assertEquals(bookPrice, book.getBookPrice());
    }
}
