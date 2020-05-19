package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.firstName LIKE '?1%' OR s.lastName LIKE '?1%'")
	Iterable<Student> findByFirstNameOrLastName(String search);

}
