package com.api.bookstoreapi.service;

import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.model.Order;

import java.util.List;

/**
 * Service class for processing orders related to books.
 * Provides methods to calculate total quantity and total revenue for a given book.
 */
public class OrderProcessor {

    /**
     * Calculates the total quantity of a book based on its orders.
     *
     * @param book The book entity for which to calculate the total quantity.
     * @return The total quantity of the book across all its orders.
     */
    public int calculateBookQuantity(Book book) {
        List<Order> orders = book.getOrders();
        int totalQuantity = 0;
        for (Order order : orders) {
            totalQuantity += order.getOrderQuantity();
        }
        return totalQuantity;
    }

    /**
     * Calculates the total revenue generated from a book based on its orders.
     *
     * @param book The book entity for which to calculate the total revenue.
     * @return The total revenue generated from the book across all its orders.
     */
    public double calculateBookTotal(Book book) {
        List<Order> orders = book.getOrders();
        double totalRevenue = 0.0;
        for (Order order : orders) {
            totalRevenue += order.getOrderTotal();
        }
        return totalRevenue;
    }
}
