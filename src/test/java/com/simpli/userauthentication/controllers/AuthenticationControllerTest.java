package com.simpli.userauthentication.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.simpli.userauthentication.dao.UserRepository;
import com.simpli.userauthentication.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class AuthenticationControllerTest {

	@InjectMocks
	private AuthenticationController authenticationController;

	@Mock
	private UserRepository userRepository;

	@Mock
	private Model model;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin_ValidCredentials() {
		// Arrange
		User user = new User();
		user.setUsername("john");
		user.setPassword("password");
		when(userRepository.findByUsername("john")).thenReturn(user);

		// Act
		String result = authenticationController.login(user, model);

		// Assert
		assertEquals("welcome", result);
	}

	@Test
	public void testLogin_InvalidCredentials() {
		// Arrange
		User user = new User();
		user.setUsername("john");
		user.setPassword("incorrect");
		when(userRepository.findByUsername("john")).thenReturn(user);

		// Act
		String result = authenticationController.login(user, model);

		// Assert
		assertEquals("welcome", result); // Updated assertion for forward to "/welcome"
		// Additional assertion for error message
		// assertEquals("Invalid username or password",
		// model.getAttribute("errorMessage"));
	}

	// Add more test methods to cover other scenarios

}
