package com.assignment.userorchestration.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.userorchestration.model.User;
import com.assignment.userorchestration.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

	@Test
	void testGetUserById() throws Exception {
		User user = new User(1L, "John", "Doe", "john.doe@example.com", "123-45-6789");
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		mockMvc.perform(get("/users/1")).andExpect(status().isOk());
	}
}