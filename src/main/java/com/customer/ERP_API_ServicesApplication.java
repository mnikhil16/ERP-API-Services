package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class that serves as the entry point for the Customer Management application.
 * It is responsible for bootstrapping the Spring Boot application and starting the server.
 * Usage:
 * The ERP_API_ServicesApplication class acts as the starting point of the entire application.
 * It initializes the Spring Boot application context and configures necessary components.
 * The application can be started by running the main method within this class.
 */
@SpringBootApplication
public class ERP_API_ServicesApplication {

	/**
	 * The main method to start the Customer application.
	 *
	 * @param args Command-line arguments (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(ERP_API_ServicesApplication.class, args);
	}

}
