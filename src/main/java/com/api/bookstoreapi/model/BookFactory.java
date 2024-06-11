package com.api.bookstoreapi.model;

/**
 * Factory class for creating Book objects.
 */

/* Why Factory Method design pattern?
* 
* I chose the Factory Method design pattern because it provides a centralized
* way to create objects, which promotes code organization and maintainability.
* It encapsulates the object creation logic, allowing us to easily modify or
* extend the creation process without affecting the client code. Additionally,
* it facilitates the adherence to the Single Responsibility Principle (SRP) by
* separating the object creation logic from other functionalities within the
* classes. This pattern also promotes loose coupling between the client code
* and the created objects, making the system more flexible and easier to test.
*/
public class BookFactory {
	 
    private BookFactory() {
        // Private constructor to prevent instantiation
    }
    /**
     * Creates a new Book object with the specified attributes.
     *
     * @param bookId     The ID of the book.
     * @param bookTitle  The title of the book.
     * @param bookAuthor The author of the book.
     * @param bookPrice  The price of the book.
     * @return The created Book object.
     */
    public static Book createBook(String bookId, String bookTitle, String bookAuthor, double bookPrice) {
        // Additional logic for book creation (if needed)
        return new Book(bookId, bookTitle, bookAuthor, bookPrice);
    }
}
