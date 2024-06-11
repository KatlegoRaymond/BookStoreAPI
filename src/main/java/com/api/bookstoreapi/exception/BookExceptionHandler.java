package com.api.bookstoreapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions thrown by controllers in the API.
 */
@ControllerAdvice
public class BookExceptionHandler {

    /**
     * Exception handler method for handling BookNotFoundException.
     * It creates a BookException with appropriate message and HTTP status.
     *
     * @param bookNotFoundException The BookNotFoundException object.
     * @return ResponseEntity containing the BookException and HTTP status NOT_FOUND.
     */
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        // Create a BookException with the message and cause of the BookNotFoundException
        BookException bookException = new BookException(
                bookNotFoundException.getMessage(),
                bookNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        // Return ResponseEntity containing the BookException and HTTP status NOT_FOUND
        return new ResponseEntity<>(bookException, HttpStatus.NOT_FOUND);
    }
}
