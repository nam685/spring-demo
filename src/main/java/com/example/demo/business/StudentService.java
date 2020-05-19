package com.example.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}
	
	public Optional<Student> findById (int id) {
		return studentRepository.findById(id);
	}
	
	public Iterable<Student> findByFirstNameOrLastName(String search) {
		return studentRepository.findByFirstNameOrLastName(search);
	}
	
	public Student add(Student param) {
		Student student = new Student();
		BeanUtils.copyProperties(param, student, "id");
		studentRepository.save(student);
		return student;
	}
	
	public Optional<Student> update(Student param) {
		Optional<Student> find = studentRepository.findById(param.getId());
		
		if (find.isPresent()) {
			Student student = find.get();
			BeanUtils.copyProperties(param, student, "id");
			studentRepository.save(student);
		}
		return find;
	}
}
