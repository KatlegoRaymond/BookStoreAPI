package com.api.bookstoreapi.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for the {@link BookExceptionHandler} class.
 */
public class BookExceptionHandlerTest {

    /**
     * Test for the handleBookNotFoundException method of {@link BookExceptionHandler}.
     * It checks if the method correctly handles BookNotFoundException and returns the expected ResponseEntity.
     */
    @Test
    public void testHandleBookNotFoundException() {
        // Create a BookNotFoundException
        BookNotFoundException exception = new BookNotFoundException("Book not found");

        // Create a BookExceptionHandler
        BookExceptionHandler handler = new BookExceptionHandler();

        // Invoke the handleBookNotFoundException method
        ResponseEntity<Object> responseEntity = handler.handleBookNotFoundException(exception);

        // Check if the ResponseEntity is not null
        assertNotNull(responseEntity);

        // Check if the response status is HttpStatus.NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        // Check if the response body is an instance of BookException
        assertNotNull(responseEntity.getBody());
        assertEquals(BookException.class, responseEntity.getBody().getClass());

        // Check if the BookException contains the correct message and HTTP status
        BookException bookException = (BookException) responseEntity.getBody();
        assertEquals("Book not found", bookException.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, bookException.getHttpStatus());
    }
}
