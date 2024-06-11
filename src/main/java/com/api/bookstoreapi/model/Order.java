package com.api.bookstoreapi.model;

import javax.persistence.*;

@Entity
@Table(name = "order_info")
public class Order {
    @Id
    private String orderId; // Unique identifier for the order
    private String orderDetails; // Details of the order
    private Integer orderQuantity; // Quantity of books ordered
    private Double orderTotal; // Total price of the order

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book; // The book associated with this order

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String orderId, String orderDetails, Integer orderQuantity, Double orderTotal) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.orderQuantity = orderQuantity;
        this.orderTotal = orderTotal;
    }
    
    
    // Getters and setters
    // Encapsulate the fields and provide getter and setter methods for access

    // Getter for orderId
    public String getOrderId() {
        return orderId;
    }

    // Setter for orderId
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    // Getter for orderDetails
    public String getOrderDetails() {
        return orderDetails;
    }

    // Setter for orderDetails
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    // Getter for orderQuantity
    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    // Setter for orderQuantity
    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    // Getter for orderTotal
    public Double getOrderTotal() {
        return orderTotal;
    }

    // Setter for orderTotal
    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    // Getter for book
    public Book getBook() {
        return book;
    }

    // Setter for book
    public void setBook(Book book) {
        this.book = book;
    }
}
