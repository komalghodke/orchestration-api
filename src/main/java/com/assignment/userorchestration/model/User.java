package com.assignment.userorchestration.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * This class represents a user in the orchestration API. It defines the
 * structure of the user data that will be stored in the database.
 * 
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */

@Entity
@Table(name = "APP_USER")
public class User {

	@Id
	private Long id;

	@NotBlank(message = "First name is mandatory")
	private String firstName;

	@NotBlank(message = "Last name is mandatory")
	private String lastName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	private String ssn;

	public User() {
	}

	public User(Long id, String firstName, String lastName, String email, String ssn) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ssn = ssn;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
