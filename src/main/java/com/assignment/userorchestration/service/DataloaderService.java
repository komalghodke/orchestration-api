package com.assignment.userorchestration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.userorchestration.model.User;
import com.assignment.userorchestration.repository.UserRepository;

import java.util.List;
import java.util.Map;

/**
 * Service class responsible for loading user data from an external dataset and saving it to the H2 database when the application starts.
 * Fetches data from https://dummyjson.com/users using RestTemplate.
 * 
 * @author Komal Ghodke
 * @version 1.0.0
 * @since 2025-02-21
 * @see <a href="https://github.com/komalghodke">GitHub Profile</a>
 */
@Service
public class DataloaderService {

	private static final Logger logger = LoggerFactory.getLogger(DataloaderService.class);

	// Use logger.debug(), logger.info(), logger.error(), etc.

	@Autowired
	private UserRepository userRepository;

	@jakarta.annotation.PostConstruct
	public void loadData() {
		String url = "https://dummyjson.com/users";
		RestTemplate restTemplate = new RestTemplate();

		try {
			Map<String, Object> response = restTemplate.getForObject(url, Map.class);
			List<Map<String, Object>> usersData = (List<Map<String, Object>>) response.get("users");

			for (Map<String, Object> userData : usersData) {
				User user = new User();
				user.setId(Long.valueOf(userData.get("id").toString()));
				user.setFirstName((String) userData.get("firstName"));
				user.setLastName((String) userData.get("lastName"));
				user.setEmail((String) userData.get("email"));
				user.setSsn((String) userData.getOrDefault("ssn", ""));
				userRepository.save(user);
			}
		} catch (Exception e) {
			// Handle exceptions, possibly with retries or logging
			System.err.println("Error loading data: " + e.getMessage());
		}
	}
}
