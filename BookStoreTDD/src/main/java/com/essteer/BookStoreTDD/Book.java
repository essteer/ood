package com.essteer.BookStoreTDD;

public class Book {
	
	private double price;
	private long ISBN;
	
	public Book(double price) {
		this.price = price;
		this.ISBN = 0;
	}
	
	public Book(double price, long ISBN) {
		this.price = price;
		this.ISBN = ISBN;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public long getISBN() {
		return this.ISBN;
	}

}
