package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query("SELECT m FROM Movie m WHERE m.name LIKE %:keyword%")
	public List<Movie> searchByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT m, COUNT(w)"
			+ " FROM Movie m"
			+ " JOIN m.showtimes s"
			+ " JOIN s.audiences w"
			+ " GROUP BY m"
			+ " ORDER BY COUNT(w) DESC")
	public List<Object[]> getPopularMovies(Pageable pageable);
	
}
