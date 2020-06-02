package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.UserService;
import com.example.demo.entities.Showtime;
import com.example.demo.security.services.UserDetailsImpl;

@Controller
@RequestMapping("/profile")
@PreAuthorize("hasRole('ROLE_USER')")
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public @ResponseBody ResponseEntity<?> getProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return ResponseEntity.ok(userDetails);
	}
	
	@GetMapping("/watchHistory")
	public @ResponseBody List<Showtime> getWatchHistory() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return userService.getWatchHistoryById(userDetails.getId()).get();
	}
}
