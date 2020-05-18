package com.example.demo;

public class Student {
	private static int idGenerator = 1;
	private final int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	public Student(String firstName, String lastName, String dateOfBirth) {
		this.id = idGenerator++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Student no. " + id + ": " + firstName + " " + lastName + ". Date of birth: " + dateOfBirth + ".\n";
	}
}
