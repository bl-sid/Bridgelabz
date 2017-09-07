package com.bridgelabz.model;

// Plain Old Java Object class with getters
public class Book {
	private String title;
	private String author;
	private String category;
	private int price;
	private int id; 

	public Book(String title, String author, String category, int price, int id){
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.id = id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
