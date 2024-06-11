package com.api.bookstoreapi.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link BookException} class.
 */
public class BookExceptionTest {

    /**
     * Test for the constructor of {@link BookException} with message and HTTP status.
     */
    @Test
    public void testBookExceptionWithMessageAndStatus() {
        String message = "Test message";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        BookException exception = new BookException(message, status);

        assertEquals(message, exception.getMessage());
        assertEquals(status, exception.getHttpStatus());
    }

    /**
     * Test for the constructor of {@link BookException} with message, cause, and HTTP status.
     */
    @Test
    public void testBookExceptionWithMessageCauseAndStatus() {
        String message = "Test message";
        Throwable cause = new RuntimeException("Test cause");
        HttpStatus status = HttpStatus.BAD_REQUEST;

        BookException exception = new BookException(message, cause, status);

        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertEquals(status, exception.getHttpStatus());
    }
}
