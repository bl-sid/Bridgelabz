package com.bridgelabz.model;

// POJO class for user database

public class User {

	private String name;
	private String email;
	private String contact;
	private String gender;
	private String password;
	private int id;

	public User(String name, String email, String contact, String gender, String password, int id){
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.password = password;
		this.id = id;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
