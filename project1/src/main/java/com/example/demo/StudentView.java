package com.example.demo;

/* to avoid strangers from calling Student.setAttribute('gibberish'); */
public class StudentView extends Student {

	public StudentView(String firstName, String lastName, String dateOfBirth) {
		super(firstName, lastName, dateOfBirth);
	}
	
	public StudentView(Student s) {
		super(s.getFirstName(), s.getLastName(), s.getDateOfBirth());
	}
	
	@Override
	public void setFirstName(String firstName) {
		System.out.println("UnsupportedOperationException");
	}
	
	@Override
	public void setLastName(String lastName) {
		System.out.println("UnsupportedOperationException");
	}

	@Override
	public void setDateOfBirth(String dateOfBirth) {
		System.out.println("UnsupportedOperationException");
	}
	
	@Override
	public String toString() {
		return "Student " + getFirstName() + " " + getLastName() + ". Date of birth: " + getDateOfBirth() + ".\n";
	}
}
