package com.simpli.userauthentication.controllers;

import com.simpli.userauthentication.dao.UserRepository;
import com.simpli.userauthentication.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/welcome")
	public String welcome(Model model) {
		// Check if user is logged in
		// If not logged in, redirect to login page
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model) {
//		System.out.println("Login method is called"); // Print statement for debugging
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("username", user.getUsername());
			return "welcome"; // Return the name of the view/template
		} else {
			model.addAttribute("errorMessage", "Invalid username or password"); // Add error message
			return "redirect:/login"; // Updated return value for invalid credentials
		}
	}

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			return "redirect:/register";
		} else {
			userRepository.save(user);
			model.addAttribute("username", user.getUsername());
			return "redirect:/welcome";
		}
	}

	@GetMapping("/logout")
	public String logout() {
		// Perform logout logic here (e.g., invalidate session, clear authentication
		// details)
		return "redirect:/login";
	}
}
