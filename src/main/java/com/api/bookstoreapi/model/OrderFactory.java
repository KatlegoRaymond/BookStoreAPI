package com.api.bookstoreapi.model;

/**
 * Factory class for creating Order objects.
 */

/* Why Factory Method design pattern?
 * 
 * I chose the Factory Method design pattern because it provides a centralized
 * way to create objects, which promotes code organization and maintainability.
 * It encapsulates the object creation logic, allowing us to easily modify or
 * extend the creation process without affecting the client code. Additionally,
 * it facilitates the adherence to the Single Responsibility Principle (SRP) by
 * separating the object creation logic from other functionalities within the
 * classes. This pattern also promotes loose coupling between the client code
 * and the created objects, making the system more flexible and easier to test.
 */

public class OrderFactory {
    public static Order createOrder(String orderId, String orderDetails, int orderQuantity, double orderTotal) {
		
    	 
    	/**
         * Creates an Order object with the provided attributes.
         *
         * @param orderId       The unique identifier for the order.
         * @param orderDetails  Details of the order.
         * @param orderQuantity The quantity of items in the order.
         * @param orderTotal    The total cost of the order.
         * @return An instance of the Order class with the specified attributes.
         */
        return new Order(orderId, orderDetails, orderQuantity, orderTotal);
    }
}
