package com.api.bookstoreapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_info")
public class Book {
    @Id
    private String bookId; // Unique identifier for the book
    private String bookTitle; // Title of the book
    private String bookAuthor; // Author of the book
    private Double bookPrice; // Price of the book

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>(); // List of orders associated with this book

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String bookId, String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }
    
    
    // Getters and setters
    // Encapsulate the fields and provide getter and setter methods for access
    
    // Getter for bookId
    public String getBookId() {
        return bookId;
    }

    // Setter for bookId
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    // Getter for bookTitle
    public String getBookTitle() {
        return bookTitle;
    }

    // Setter for bookTitle
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Getter for bookAuthor
    public String getBookAuthor() {
        return bookAuthor;
    }

    // Setter for bookAuthor
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // Getter for bookPrice
    public Double getBookPrice() {
        return bookPrice;
    }

    // Setter for bookPrice
    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    // Getter for orders
    public List<Order> getOrders() {
        return orders;
    }

    // Setter for orders
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // Method to add an order to the list of orders associated with this book
    public void addOrder(Order order) {
        orders.add(order);
        order.setBook(this); // Set the book of the order to this book
    }

    // Method to remove an order from the list of orders associated with this book
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setBook(null); // Set the book of the order to null (indicating it's no longer associated with any book)
    }
}
