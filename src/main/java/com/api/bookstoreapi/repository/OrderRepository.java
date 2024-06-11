package com.api.bookstoreapi.repository;

import com.api.bookstoreapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on Order entities.
 * Extends JpaRepository to leverage Spring Data JPA functionality.
 */
public interface OrderRepository extends JpaRepository<Order, String> {

    /**
     * Finds a list of orders by their details.
     *
     * @param orderDetails The details of the order(s) to find.
     * @return A list of orders that match the given details.
     */
    List<Order> findByOrderDetails(String orderDetails);
}
