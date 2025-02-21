package com.assignment.userorchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Orchestration API Spring Boot application.
 * The application loads user data from an external dataset into an in-memory H2 database and provides RESTful endpoints for querying the data.
 *  
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */
@SpringBootApplication
public class OrchestrationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrationApiApplication.class, args);
	}

}
