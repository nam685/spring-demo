package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>, StudentRepositoryCustom {

}
