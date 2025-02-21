package com.assignment.userorchestration.repository;

import com.assignment.userorchestration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for User entity.
 * Provides methods for CRUD operations and custom queries.
 * 
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrSsnContainingIgnoreCase(
			String firstName, String lastName, String ssn);

	Optional<User> findByEmail(String email);
}
