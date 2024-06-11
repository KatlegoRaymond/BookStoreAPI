package com.api.bookstoreapi.controller;

import com.api.bookstoreapi.model.Order;
import com.api.bookstoreapi.response.ResponseHandler;
import com.api.bookstoreapi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    OrderService orderService;

    // Constructor-based injection of OrderService
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint to get details of a specific order by its ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Object> getOrderDetails(@PathVariable("orderId") String orderId) {
        // Build response using ResponseHandler with success status and fetched order data
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, orderService.getOrder(orderId));
    }

    // Endpoint to get details of all orders
    @GetMapping("/")
    public List<Order> getAllOrderDetails() {
        // Retrieve all orders from the service
        return orderService.getAllOrders();
    }

    // Endpoint to create a new order
    @PostMapping("/")
    public String createOrderDetails(@RequestBody Order order) {
        // Create the order using the service
        orderService.createOrder(order);
        return "Order Created Successfully";
    }

    // Endpoint to update an existing order
    @PutMapping("/")
    public String updateOrderDetails(@RequestBody Order order) {
        // Update the order using the service
        orderService.updateOrder(order);
        return "Order Updated Successfully";
    }

    // Endpoint to delete an order by its ID
    @DeleteMapping("/{orderId}")
    public String deleteOrderDetails(@PathVariable("orderId") String orderId) {
        // Delete the order using the service
        orderService.deleteOrder(orderId);
        return "Order Deleted Successfully";
    }
}
