package com.api.bookstoreapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for the {@link OrderFactory} class.
 */
public class OrderFactoryTest {

    /**
     * Test for the {@link OrderFactory#createOrder} method.
     * It checks if the method correctly creates an Order object with the provided attributes.
     */
    @Test
    public void testCreateOrder() {
        // Given
        String orderId = "123";
        String orderDetails = "Sample order";
        int orderQuantity = 2;
        double orderTotal = 50.0;

        // When
        Order order = OrderFactory.createOrder(orderId, orderDetails, orderQuantity, orderTotal);

        // Then
        assertNotNull(order);
        assertEquals(orderId, order.getOrderId());
        assertEquals(orderDetails, order.getOrderDetails());
        assertEquals(orderQuantity, order.getOrderQuantity());
        assertEquals(orderTotal, order.getOrderTotal());
    }
}
