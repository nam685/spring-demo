package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

	@Query("SELECT c FROM Cinema c WHERE c.name LIKE %:keyword%")
	public List<Cinema> searchByKeyword(@Param("keyword") String keyword);
	
}
