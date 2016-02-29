package com.fellowshopper.core;

public class User {
	
	
	private String firstName;
	private String lastName;
	private String UID;
	private String phoneNumber;
	
	private static int totalRequestors=0;
	
	public User(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
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
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public static int getTotalRequestors() {
		return totalRequestors;
	}
	public static void setTotalRequestors(int totalRequestors) {
		User.totalRequestors = totalRequestors;
	}
	
}
