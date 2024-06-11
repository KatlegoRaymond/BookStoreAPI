package com.api.bookstoreapi.repository;

import com.api.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on Book entities.
 * Extends JpaRepository to leverage Spring Data JPA functionality.
 */
public interface BookRepository extends JpaRepository<Book, String> {
    
    /**
     * Finds a list of books by their title.
     *
     * @param bookTitle The title of the book(s) to find.
     * @return A list of books that match the given title.
     */
    List<Book> findByBookTitle(String bookTitle);
}
