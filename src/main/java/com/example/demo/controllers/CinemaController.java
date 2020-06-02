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

import com.example.demo.business.CinemaService;
import com.example.demo.entities.Cinema;
import com.example.demo.entities.Showtime;

@Controller
@RequestMapping("/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;

	@GetMapping()
	public @ResponseBody List<Cinema> find(
			@RequestParam(required=false) String keyword) {
		if (keyword == null) {
			return cinemaService.findAll();
		}
		return cinemaService.search(keyword);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> listMoviesShown(@PathVariable("id") int id) {
		Optional<List<Showtime>> find = cinemaService.getShows(id);
		if (find.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(find.get(), HttpStatus.OK);
	}
	
}
