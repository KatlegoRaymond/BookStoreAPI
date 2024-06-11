package com.api.bookstoreapi.service;

import com.api.bookstoreapi.model.Book;
import com.api.bookstoreapi.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class for the {@link OrderProcessor} service.
 */
public class OrderProcessorTest {

    @Mock
    private Book book;

    /**
     * Initializes mocks and sets up the test environment.
     */
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for the {@link OrderProcessor#calculateBookQuantity(Book)} method.
     * It checks if the total quantity of a book is correctly calculated.
     */
    @Test
    public void testCalculateBookQuantity() {
        // Given
        setUp();
        Order order1 = new Order("1", "Test Order 1", 2, 20.0);
        Order order2 = new Order("2", "Test Order 2", 3, 30.0);
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        when(book.getOrders()).thenReturn(orders);
        OrderProcessor orderProcessor = new OrderProcessor();

        // When
        int totalQuantity = orderProcessor.calculateBookQuantity(book);

        // Then
        assertEquals(5, totalQuantity);
    }

    /**
     * Test for the {@link OrderProcessor#calculateBookTotal(Book)} method.
     * It checks if the total revenue generated from a book is correctly calculated.
     */
    @Test
    public void testCalculateBookTotal() {
        // Given
        setUp();
        Order order1 = new Order("1", "Test Order 1", 2, 20.0);
        Order order2 = new Order("2", "Test Order 2", 3, 30.0);
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        when(book.getOrders()).thenReturn(orders);
        OrderProcessor orderProcessor = new OrderProcessor();

        // When
        double totalRevenue = orderProcessor.calculateBookTotal(book);

        // Then
        assertEquals(50.0, totalRevenue);
    }
}
