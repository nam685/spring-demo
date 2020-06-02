package com.example.demo.business;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Showtime;
import com.example.demo.repositories.CinemaRepository;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}
	
	public Optional<List<Showtime>> getShows(int id) {
		Optional<Cinema> find = cinemaRepository.findById(id);
		List<Showtime> results = null;
		
		if (find.isPresent()) {
			Cinema cinema = find.get();
			Set<Showtime> showtimes = cinema.getShowtimes();
			
			// let's not display its cinema
			showtimes.forEach((showtime)->{showtime.setCinema(null);});
			
			results = showtimes.stream().collect(Collectors.toList());
		}
		
		return Optional.of(results);
	}
	
	public List<Cinema> search(String keyword) {
		return cinemaRepository.searchByKeyword(keyword);
	}
}
