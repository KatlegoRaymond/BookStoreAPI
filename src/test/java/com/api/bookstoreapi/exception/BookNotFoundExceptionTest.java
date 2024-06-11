package com.api.bookstoreapi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for the {@link BookNotFoundException} class.
 */
public class BookNotFoundExceptionTest {

    /**
     * Test for the constructors of {@link BookNotFoundException}.
     * It checks if the constructors correctly initialize the exception with the provided message and cause.
     */
    @Test
    public void testConstructors() {
        // Test constructor with message
        String message = "Book not found";
        BookNotFoundException exceptionWithMessage = new BookNotFoundException(message);
        assertNotNull(exceptionWithMessage);
        assertEquals(message, exceptionWithMessage.getMessage());
        assertNull(exceptionWithMessage.getCause());

        // Test constructor with message and cause
        Throwable cause = new RuntimeException("Internal error");
        BookNotFoundException exceptionWithMessageAndCause = new BookNotFoundException(message, cause);
        assertNotNull(exceptionWithMessageAndCause);
        assertEquals(message, exceptionWithMessageAndCause.getMessage());
        assertEquals(cause, exceptionWithMessageAndCause.getCause());
    }
}
