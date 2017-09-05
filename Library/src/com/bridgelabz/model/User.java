package com.bridgelabz.model;

// POJO class for user database

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
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getContact(){
		return contact;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getPassword(){
		return password;
	}
}
