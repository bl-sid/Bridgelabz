package com.bridgelabz;

public class User {
	
	private String fname;
	private String lname;
	private String email;
	private String contact;
	private String password;
	User(String fname, String lname, String email, String contact, String password){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	
	User(String fname, String lname, String email, String contact){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
	}
	
	String getFname() {
		return fname;
	}
	
	String getLname() {
		return lname;
	}
	
	String getEmail() {
		return email;
	}
	
	String getContact() {
		return contact;
	}
	
	String getPassword() {
		return password;
	}
	
	void setFname(String fname) {
		this.fname = fname;
	}
	
	void setLname(String lname) {
		this.lname = lname;
	}
	
	void setEmail(String email) {
		this.email = email;
	}
	
	void setContact(String contact) {
		this.contact = contact;
	}
}
