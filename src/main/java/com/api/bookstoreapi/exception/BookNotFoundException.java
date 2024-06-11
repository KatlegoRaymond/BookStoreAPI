package com.api.bookstoreapi.exception;

/**
 * Custom exception class for handling cases where a book is not found in the API.
 */
public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L; // Serial version UID for serialization

    /**
     * Constructor for creating a BookNotFoundException with a message.
     *
     * @param message The detail message for the exception.
     */
    public BookNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor for creating a BookNotFoundException with a message and cause.
     *
     * @param message The detail message for the exception.
     * @param cause   The cause of the exception.
     */
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
