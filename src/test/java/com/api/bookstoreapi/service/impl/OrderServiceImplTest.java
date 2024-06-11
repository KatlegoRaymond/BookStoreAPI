package com.api.bookstoreapi.service.impl;

import com.api.bookstoreapi.model.Order;
import com.api.bookstoreapi.repository.OrderRepository;
import com.api.bookstoreapi.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    private OrderService orderService;
    private AutoCloseable autoCloseable;
    private Order order;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
        order = new Order("1", "Order Details", 5, 100.0);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateOrder() {
        when(orderRepository.save(order)).thenReturn(order);
        assertThat(orderService.createOrder(order)).isEqualTo("Order Created Successfully");
    }

    @Test
    void testGetOrder() {
        when(orderRepository.findById("1")).thenReturn(Optional.ofNullable(order));
        assertThat(orderService.getOrder("1").getOrderDetails()).isEqualTo(order.getOrderDetails());
    }

    @Test
    void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>(Collections.singletonList(order)));
        assertThat(orderService.getAllOrders().get(0).getOrderQuantity()).isEqualTo(order.getOrderQuantity());
    }

    @Test
    void testUpdateOrder() {
        when(orderRepository.save(order)).thenReturn(order);
        assertThat(orderService.updateOrder(order)).isEqualTo("Order Updated Successfully");
    }

    @Test
    void testDeleteOrder() {
    	mock(Order.class);
    	mock(OrderRepository.class, Mockito.CALLS_REAL_METHODS);
    	
    	doAnswer(Answers.CALLS_REAL_METHODS).when(orderRepository)
        .deleteById(any());
    	 
        assertThat(orderService.deleteOrder("1")).isEqualTo("Order Deleted Successfully");
    }
 
}

