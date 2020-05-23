package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.UserService;
import com.example.demo.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public @ResponseBody List<User> find(
			@RequestParam String criteria) {
		return criteria.equalsIgnoreCase("birthday") ? userService.findBirthdayBois() : userService.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findByID(@PathVariable("id") int id) {
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping()
	public @ResponseBody User add(@RequestBody User param) {
		return userService.add(param);
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<Object> update(@RequestBody User param) {
		Optional<User> user = userService.update(param);
		if (user.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	
}