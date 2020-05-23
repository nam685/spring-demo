package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);

	@Query("SELECT u FROM User u WHERE MONTH(CURRENT_DATE) = MONTH(u.dateOfBirth) AND DAY(CURRENT_DATE) = DAY(u.dateOfBirth)")
	Iterable<User> findBirthdayBois();

}
