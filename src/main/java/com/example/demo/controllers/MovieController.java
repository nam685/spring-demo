package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.MovieService;
import com.example.demo.entities.Movie;
import com.example.demo.entities.Showtime;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping()
	public @ResponseBody List<Movie> find(
			@RequestParam(required=false) String keyword) {
		if (keyword == null) {
			return movieService.findAll();
		}
		return movieService.search(keyword);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> suggestCinema(@PathVariable("id") int id) {
		Optional<List<Showtime>> find = movieService.getShows(id);
		if (find.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(find.get(), HttpStatus.OK);
	}
}
