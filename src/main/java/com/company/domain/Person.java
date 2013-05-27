package com.company.domain;

public class Person {
	private String fistName;
	private String lastName;

	public Person() {
	}
	
	public Person(String fname, String lname) {
		this.fistName=fname;
		this.lastName=lname;
	}
	
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}