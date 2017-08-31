package com.bridgelabz;

public class User {

	private String name;
	private String email;
	private String contact;
	private String gender;
	private String password;
	
	public User(String name, String email, String contact, String gender, String password){
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.password = password;
	}
	
	String getName(){
		return name;
	}
	
	String getEmail(){
		return email;
	}
	
	String getContact(){
		return contact;
	}
	
	String getGender(){
		return gender;
	}
	
	String getPassword(){
		return password;
	}
}
