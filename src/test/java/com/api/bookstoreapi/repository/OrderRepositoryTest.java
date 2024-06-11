package com.api.bookstoreapi.repository;

import com.api.bookstoreapi.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest; 

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Integration tests for the OrderRepository class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class OrderRepositoryTest {
 

    @Autowired
    private OrderRepository orderRepository;

    private Order order1;
    private Order order2;

    /**
     * Set up test data before each test method execution.
     */
    @BeforeEach
    void setUp() {
        // Create sample orders and save them to the repository
        order1 = new Order("1", "Order1", 5, 100.0);
        order2 = new Order("2", "Order2", 10, 200.0);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    /**
     * Test case to verify finding orders by order details when found.
     * Expectation: The order with the given order details should be found.
     */
    @Test
    void testFindByOrderDetails_Found() throws Exception {
        // When
        List<Order> orderList = orderRepository.findByOrderDetails("Order1");

        // Then
        assertThat(orderList.get(0).getOrderId()).isEqualTo(order1.getOrderId());
        assertThat(orderList.get(0).getOrderQuantity()).isEqualTo(order1.getOrderQuantity());
        assertThat(orderList.get(0).getOrderTotal()).isEqualTo(order1.getOrderTotal());
    }

    /**
     * Test case to verify finding orders by order details when not found.
     * Expectation: No order should be found for the given order details.
     */
    @Test
    void testFindByOrderDetails_NotFound() throws Exception {
        // When
        List<Order> orderList = orderRepository.findByOrderDetails("Order3");

        // Then
        assertThat(orderList.isEmpty()).isTrue();
    }
}
