package com.api.bookstoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

    // The main method, which is the entry point of the application
    public static void main(String[] args) {
        // SpringApplication.run() starts the Spring Boot application
        // It takes two parameters: the main class (BookstoreApplication.class) and command-line arguments (args)
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
