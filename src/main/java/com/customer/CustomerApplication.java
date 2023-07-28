package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class that serves as the entry point for the Customer Management application.
 * It is responsible for bootstrapping the Spring Boot application and starting the server.
 *
 * Usage:
 * The CustomerApplication class acts as the starting point of the entire application.
 * It initializes the Spring Boot application context and configures necessary components.
 * The application can be started by running the main method within this class.
 */
@SpringBootApplication
public class CustomerApplication {

	/**
	 * The main method to start the Customer application.
	 *
	 * @param args Command-line arguments (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
