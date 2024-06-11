package com.api.bookstoreapi.service;

import com.api.bookstoreapi.model.Book;

import java.util.List;

/**
 * Service interface for managing Book entities.
 * Defines methods for creating, updating, deleting, and retrieving books.
 */
public interface BookService {

    /**
     * Creates a new book.
     *
     * @param book The book entity to create.
     * @return A message indicating the result of the create operation.
     */
    public String createBook(Book book);

    /**
     * Updates an existing book.
     *
     * @param book The book entity to update.
     * @return A message indicating the result of the update operation.
     */
    public String updateBook(Book book);

    /**
     * Deletes a book by its ID.
     *
     * @param bookId The ID of the book to delete.
     * @return A message indicating the result of the delete operation.
     */
    public String deleteBook(String bookId);

    /**
     * Retrieves a book by its ID.
     *
     * @param bookId The ID of the book to retrieve.
     * @return The book entity with the specified ID.
     */
    public Book getBook(String bookId);

    /**
     * Retrieves all books.
     *
     * @return A list of all book entities.
     */
    public List<Book> getAllBooks();

    /**
     * Retrieves books by their title.
     *
     * @param bookTitle The title of the books to retrieve.
     * @return A list of book entities with the specified title.
     */
    public List<Book> getByBookTitle(String bookTitle);
}
