package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.business.StudentService;
import com.example.demo.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping()
	public @ResponseBody List<Student> getAllStudents() {
		return studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> getStudentByID(@PathVariable("id") int id) {
		Optional<Student> student = studentService.findById(id);
		if (student.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(student.get(), HttpStatus.OK);
	}
	
	/* return students who have the searched word in their first name or last name */
	@GetMapping("/byName")
	public @ResponseBody Iterable<Student> getStudentByName(
			@RequestParam String search) {
		return studentService.findByFirstNameOrLastName(search);
	}
	
	@PostMapping()
	public @ResponseBody Student addStudent(@RequestBody Student param) {
		return studentService.add(param);
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<Object> updateStudent(@RequestBody Student param) {
		Optional<Student> student = studentService.update(param);
		if (student.isEmpty()) {
			return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}
}
