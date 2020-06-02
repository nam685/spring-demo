package com.example.demo.business;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.entities.Showtime;
import com.example.demo.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	

	public Optional<List<Showtime>> getShows(int id) {
		Optional<Movie> find = movieRepository.findById(id);
		List<Showtime> results = null;
		
		if (find.isPresent()) {
			Movie movie = find.get();
			Set<Showtime> showtimes = movie.getShowtimes();
			
			// let's not display its movie
			showtimes.forEach((showtime)->{showtime.setMovie(null);});
			
			results = showtimes.stream().collect(Collectors.toList());
		}
		
		return Optional.of(results);
	}
	
	public List<Movie> search(String keyword) {
		return movieRepository.searchByKeyword(keyword);
	}
	
	// returns 3 most viewed movies
	public List<Object[]> getPopularMovies() {
		return movieRepository.getPopularMovies(PageRequest.of(0, 3));
	}
}
