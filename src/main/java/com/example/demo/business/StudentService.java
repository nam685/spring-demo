package com.example.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> search(String search) {
		return StringUtils.isEmpty(search) ? (List<Student>) studentRepository.findAll() : (List<Student>) studentRepository.findByFirstNameOrLastName(search);
	}
	
	public Optional<Student> findById (int id) {
		return studentRepository.findById(id);
	}
	
	public Student add(Student param) {
		Student student = new Student();
		BeanUtils.copyProperties(param, student, "id");
		studentRepository.save(student);
		return student;
	}
	
	public Optional<Student> update(Student param) {
		Optional<Student> find = studentRepository.findById(param.getId());
		Student student = null;
		
		if (find.isPresent()) {
			student = find.get();
			BeanUtils.copyProperties(param, student, "id");
			studentRepository.save(student);
		}
		return Optional.of(student);
		
	}
}
