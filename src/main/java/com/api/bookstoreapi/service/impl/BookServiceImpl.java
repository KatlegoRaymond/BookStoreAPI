package com.api.bookstoreapi.service.impl;

import com.api.bookstoreapi.exception.BookNotFoundException;
import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.repository.BookRepository;
import com.api.bookstoreapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the BookService interface.
 * Provides methods for creating, updating, deleting, and retrieving books.
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Constructor for BookServiceImpl.
     * @param bookRepository The BookRepository to be used for database operations.
     */
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Creates a new book.
     * @param book The book entity to create.
     * @return A message indicating the result of the create operation.
     */
    @Override
    public String createBook(Book book) {
        // Additional business logic can be added here if needed
        bookRepository.save(book);
        return "Book Created Successfully";
    }

    /**
     * Updates an existing book.
     * @param book The book entity to update.
     * @return A message indicating the result of the update operation.
     */
    @Override
    public String updateBook(Book book) {
        // Additional business logic can be added here if needed
        bookRepository.save(book);
        return "Book Updated Successfully";
    }

    /**
     * Deletes a book by its ID.
     * @param bookId The ID of the book to delete.
     * @return A message indicating the result of the delete operation.
     */
    @Override
    public String deleteBook(String bookId) {
        // Additional business logic can be added here if needed
        bookRepository.deleteById(bookId);
        return "Book Deleted Successfully";
    }

    /**
     * Retrieves a book by its ID.
     * @param bookId The ID of the book to retrieve.
     * @return The book entity with the specified ID.
     * @throws BookNotFoundException if the book with the specified ID is not found.
     */
    @Override
    public Book getBook(String bookId) {
        // Additional business logic can be added here if needed
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
        return optionalBook.get();
    }

    /**
     * Retrieves all books.
     * @return A list of all book entities.
     */
    @Override
    public List<Book> getAllBooks() {
        // Additional business logic can be added here if needed
        return bookRepository.findAll();
    }

    /**
     * Retrieves books by their title.
     * @param bookTitle The title of the books to retrieve.
     * @return A list of book entities with the specified title.
     */
    @Override
    public List<Book> getByBookTitle(String bookTitle) {
        // Additional business logic can be added here if needed
        return bookRepository.findByBookTitle(bookTitle);
    }
}
