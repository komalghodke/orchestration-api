package com.assignment.userorchestration.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

/**
 * Global exception handler for the Orchestration API.
 * This class provides a centralized way to handle exceptions throughout the application.
 * 
 * It uses @ControllerAdvice to mark it as a global exception handler and  defines methods to handle various exceptions using @ExceptionHandler.
 *
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	 /**
     * Handles all other exceptions.
     *
     * @param ex the exception
     * @param request the web request
     * @return a ResponseEntity with error details
     */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		// Log the exception
		return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
	}
}
