package com.example.demo;

public interface StudentRepositoryCustom {
	public Iterable<Student> findByFirstOrLastName(String name);
}
