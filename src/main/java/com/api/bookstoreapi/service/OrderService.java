package com.api.bookstoreapi.service;

import com.api.bookstoreapi.model.Order;

import java.util.List;

/**
 * Service interface for managing Order entities.
 * Defines methods for creating, updating, deleting, and retrieving orders.
 */
public interface OrderService {

    /**
     * Creates a new order.
     *
     * @param order The order entity to create.
     * @return A message indicating the result of the create operation.
     */
    public String createOrder(Order order);

    /**
     * Updates an existing order.
     *
     * @param order The order entity to update.
     * @return A message indicating the result of the update operation.
     */
    public String updateOrder(Order order);

    /**
     * Deletes an order by its ID.
     *
     * @param orderId The ID of the order to delete.
     * @return A message indicating the result of the delete operation.
     */
    public String deleteOrder(String orderId);

    /**
     * Retrieves an order by its ID.
     *
     * @param orderId The ID of the order to retrieve.
     * @return The order entity with the specified ID.
     */
    public Order getOrder(String orderId);

    /**
     * Retrieves all orders.
     *
     * @return A list of all order entities.
     */
    public List<Order> getAllOrders();

    /**
     * Retrieves orders by their details.
     *
     * @param orderDetails The details of the orders to retrieve.
     * @return A list of order entities with the specified details.
     */
    public List<Order> getByOrderDetails(String orderDetails);
}
