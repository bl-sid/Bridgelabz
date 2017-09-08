package com.bridgelabz.model;

// POJO class for user database

public class User {

	private String name;
	private String email;
	private String contact;
	private String gender;
	private String password;
	private int userId;

	public User(String name, String email, String contact, String gender, String password, int userId){
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.password = password;
		this.userId = userId;
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
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
