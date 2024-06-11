package com.api.bookstoreapi.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for handling exceptions related to book operations in the API.
 */
@SuppressWarnings("serial")
public class BookException extends RuntimeException {
    private final HttpStatus httpStatus; // HTTP status associated with the exception

    /**
     * Constructor for creating a BookException with a message and HTTP status.
     *
     * @param message    The detail message for the exception.
     * @param httpStatus The HTTP status associated with the exception.
     */
    public BookException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Constructor for creating a BookException with a message, cause, and HTTP status.
     *
     * @param message    The detail message for the exception.
     * @param cause      The cause of the exception.
     * @param httpStatus The HTTP status associated with the exception.
     */
    public BookException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    /**
     * Get the HTTP status associated with the exception.
     *
     * @return The HTTP status.
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
