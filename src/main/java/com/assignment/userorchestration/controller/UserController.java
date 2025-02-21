package com.assignment.userorchestration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.userorchestration.model.User;
import com.assignment.userorchestration.repository.UserRepository;

import java.util.List;

import javax.validation.Valid;

/**
 * Controller class that provides RESTful endpoints to fetch users based on various criteria.
 * Endpoints:
 * - List all users or perform a free text search
 * - Get a user by ID
 * - Get a user by email
 * 
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// a. List all users based on free text search
	@GetMapping
	public List<User> getUsers(@RequestParam(required = false) String query) {
		if (query != null && !query.isEmpty()) {
			return userRepository
					.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrSsnContainingIgnoreCase(query,
							query, query);
		} else {
			return userRepository.findAll();
		}
	}

	// b. Find a specific user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id).map(user -> ResponseEntity.ok().body(user))
				.orElse(ResponseEntity.notFound().build());
	}

	// b. Find a specific user by email
	@GetMapping("/email")
	public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
		return userRepository.findByEmail(email).map(user -> ResponseEntity.ok().body(user))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser);
	}

}
