package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@GetMapping("/student")
	public ArrayList<StudentView> getAllStudents() {
		return FakeDatabase.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public StudentView getStudentByID(@PathVariable("id") int id) {
		return FakeDatabase.getStudentByID(id);
	}
	
	/* return students who have the searched word in their first name or last name */
	@GetMapping("/student")
	public ArrayList<StudentView> getStudentByName(@RequestParam(value="search", required=true) String search) {
		ArrayList<StudentView> results = FakeDatabase.getByFirstName(search);
		results.addAll(FakeDatabase.getByLastName(search));
		return results;
	}
	
	@PutMapping("/student")
	public void addStudent(
			@RequestParam(value="firstName", required=true) String firstName,
			@RequestParam(value="lastName", required=true) String lastName,
			@RequestParam(value="dateOfBirth", required=true) String dateOfBirth
			) {
		FakeDatabase.addStudent(firstName, lastName, dateOfBirth);
	}
	
	@PostMapping("/student")
	public void updateStudent(
			@RequestParam(value="id", required=true) int id,
			@RequestParam(value="firstName", required=true) String firstName,
			@RequestParam(value="lastName", required=true) String lastName,
			@RequestParam(value="dateOfBirth", required=true) String dateOfBirth
			) {
		FakeDatabase.update(id, firstName, lastName, dateOfBirth);
	}
}
