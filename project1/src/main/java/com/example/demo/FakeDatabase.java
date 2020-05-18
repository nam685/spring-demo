package com.example.demo;

import java.util.ArrayList;

public class FakeDatabase {
	private static ArrayList<StudentView> students = new ArrayList<StudentView>();
	
	public FakeDatabase() {
		// default student: me!
		students.add(new StudentView("Bi", "Beo", "23/07/1999"));
	}
	
	public static ArrayList<StudentView> getAllStudents() {
		return students;
	}
	
	// if fail to find, returns null
	public static StudentView getStudentByID(int id) {
		for (StudentView s : students) {
			if (s.getId() == id) return s;
		};
		return null;
	}
	
	// does nothing if duplicate
	public static void addStudent(String firstName, String lastName, String dateOfBirth) {
		students.add(new StudentView(firstName, lastName, dateOfBirth));
	}
	
	public static ArrayList<StudentView> getByFirstName(String fn) {
		ArrayList<StudentView> results = new ArrayList<StudentView>();
		for (StudentView s : students) {
			if (s.getFirstName() == fn) results.add(s);
		}
		return results;
	}
	
	public static ArrayList<StudentView> getByLastName(String ln) {
		ArrayList<StudentView> results = new ArrayList<StudentView>();
		for (StudentView s : students) {
			if (s.getLastName() == ln) results.add(s);
		}
		return results;
	}
	
	public static void update(int id, String firstName, String lastName, String dateOfBirth) {
		for (Student s : students) {
			if (s.getId() == id) {
				s.setFirstName(firstName);
				s.setLastName(lastName);
				s.setDateOfBirth(dateOfBirth);
				return;
			}
		}
	}
}
