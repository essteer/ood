package com.fdmgroup.tddExercise;

public class Book {
	
	private double price;
	
	public Book() {
		this(1);
	}

	public Book(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

}
