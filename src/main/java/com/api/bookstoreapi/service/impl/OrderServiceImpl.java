package com.api.bookstoreapi.service.impl;

import com.api.bookstoreapi.model.Order;
import com.api.bookstoreapi.repository.OrderRepository;
import com.api.bookstoreapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the OrderService interface.
 * Provides methods for creating, updating, deleting, and retrieving orders.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * Constructor for OrderServiceImpl.
     * @param orderRepository The OrderRepository to be used for database operations.
     */
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Creates a new order.
     * @param order The order entity to create.
     * @return A message indicating the result of the create operation.
     */
    @Override
    public String createOrder(Order order) {
        orderRepository.save(order);
        return "Order Created Successfully";
    }

    /**
     * Updates an existing order.
     * @param order The order entity to update.
     * @return A message indicating the result of the update operation.
     */
    @Override
    public String updateOrder(Order order) {
        orderRepository.findById(order.getOrderId());
       
        orderRepository.save(order);
        return "Order Updated Successfully";
         
    }

    /**
     * Deletes an order by its ID.
     * @param orderId The ID of the order to delete.
     * @return A message indicating the result of the delete operation.
     */
    @Override
    public String deleteOrder(String orderId) {
    	 orderRepository.findById(orderId);
         
    	 orderRepository.deleteById(orderId);
         return "Order Deleted Successfully";
        
    }

    /**
     * Retrieves an order by its ID.
     * @param orderId The ID of the order to retrieve.
     * @return The order entity with the specified ID.
     */
    @Override
    public Order getOrder(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElse(null);
    }

    /**
     * Retrieves all orders.
     * @return A list of all order entities.
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Retrieves orders by their details.
     * @param orderDetails The details of the orders to retrieve.
     * @return A list of order entities with the specified details.
     */
    @Override
    public List<Order> getByOrderDetails(String orderDetails) {
        return orderRepository.findByOrderDetails(orderDetails);
    }
}
