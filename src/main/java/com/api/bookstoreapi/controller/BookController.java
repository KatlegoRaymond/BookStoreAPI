package com.api.bookstoreapi.controller;

import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.response.ResponseHandler;
import com.api.bookstoreapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    private final BookService bookService;

    // Constructor-based injection of BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoint to get details of a specific book by its ID
    @GetMapping("/{bookId}")
    public ResponseEntity<Object> getBookDetails(@PathVariable("bookId") String bookId) {
        // Build response using ResponseHandler with success status and fetched book data
        return ResponseHandler.responseBuilder("Requested Book Details are given here",
                HttpStatus.OK, bookService.getBook(bookId));
    }

    // Endpoint to get details of all books
    @GetMapping("/")
    public List<Book> getAllBookDetails() {
        // Retrieve all books from the service
        return bookService.getAllBooks();
    }

    // Endpoint to create a new book
    @PostMapping("/")
    public String createBookDetails(@RequestBody Book book) {
        // Create the book using the service
        bookService.createBook(book);
        return "Book Created Successfully";
    }

    // Endpoint to update an existing book
    @PutMapping("/")
    public String updateBookDetails(@RequestBody Book book) {
        // Update the book using the service
        bookService.updateBook(book);
        return "Book Updated Successfully";
    }

    // Endpoint to delete a book by its ID
    @DeleteMapping("/{bookId}")
    public String deleteBookDetails(@PathVariable("bookId") String bookId) {
        // Delete the book using the service
        bookService.deleteBook(bookId);
        return "Book Deleted Successfully";
    }
}
