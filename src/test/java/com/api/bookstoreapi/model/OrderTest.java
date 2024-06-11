package com.api.bookstoreapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Order class.
 */
public class OrderTest {

    /**
     * Test case to verify the constructor and getters of the Order class.
     */
    @Test
    public void testOrderConstructorAndGetters() {
        // Create an order object with sample data
        Order order = new Order("1", "Details", 2, 59.98);
        
        // Assert that the getters return the correct values
        assertEquals("1", order.getOrderId());
        assertEquals("Details", order.getOrderDetails());
        assertEquals(2, order.getOrderQuantity());
        assertEquals(59.98, order.getOrderTotal());
    }

    /**
     * Test case to verify the setters of the Order class.
     */
    @Test
    public void testOrderSetters() {
        // Create a new order object
        Order order = new Order();
        
        // Set values using setters
        order.setOrderId("1");
        order.setOrderDetails("Details");
        order.setOrderQuantity(2);
        order.setOrderTotal(59.98);
        
        // Assert that the getters return the values set by the setters
        assertEquals("1", order.getOrderId());
        assertEquals("Details", order.getOrderDetails());
        assertEquals(2, order.getOrderQuantity());
        assertEquals(59.98, order.getOrderTotal());
    }
}
