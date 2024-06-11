package com.api.bookstoreapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for building standardized API responses.
 */
public class ResponseHandler {

    /**
     * Builds a standardized response entity with a message, HTTP status, and response data.
     *
     * @param message The message to include in the response.
     * @param status The HTTP status to set in the response.
     * @param responseData The data to include in the response.
     * @return A ResponseEntity containing the response map and the specified HTTP status.
     */
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object responseData) {
        // Create a map to hold the response details
        Map<String, Object> response = new HashMap<>();
        // Add the message to the response map
        response.put("message", message);
        // Add the response data to the response map
        response.put("data", responseData);
        // Return a ResponseEntity with the response map and the specified HTTP status
        return new ResponseEntity<>(response, status);
    }
}
