package com.api.bookstoreapi.repository;

import com.api.bookstoreapi.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom implementation of the BookRepository interface.
 * Provides an in-memory storage and retrieval of Book entities.
 */
public abstract class BookRepositoryImpl implements BookRepository {

    // List to store Book entities in memory
    private final List<Book> books = new ArrayList<>();

    /**
     * Finds a list of books by their title.
     *
     * @param bookTitle The title of the book(s) to find.
     * @return A list of books that match the given title.
     */
    @Override
    public List<Book> findByBookTitle(String bookTitle) {
        List<Book> result = new ArrayList<>();
        for (Book book : getBooks()) {
            if (book.getBookTitle().equals(bookTitle)) {
                result.add(book);
            }
        }
        return result;
    }

	public List<Book> getBooks() {
		return books;
	}
 
}
