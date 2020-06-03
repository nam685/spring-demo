package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.AppService;
import com.example.demo.business.MovieService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping()
	public @ResponseBody String greetings() {
		return appService.greetings();
	}
	
	@GetMapping("/featured")
	public @ResponseBody ResponseEntity<?> getPopularMovies() {
		return ResponseEntity.ok(movieService.getPopularMovies());
	}
}
