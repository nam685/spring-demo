package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE MONTH(CURRENT_DATE) = MONTH(u.dateOfBirth) AND DAY(CURRENT_DATE) = DAY(u.dateOfBirth)")
	List<User> findBirthdayBois();
}
