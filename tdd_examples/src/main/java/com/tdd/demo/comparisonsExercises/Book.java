package com.tdd.demo.comparisonsExercises;

import java.util.Comparator;

public class Book implements Comparable<Book>{
	
	public static Comparator<Book> NAME_COMPARATOR = Comparator
			.comparing(Book::getTitle);
	
	public static Comparator<Book> PAGE_COMPARATOR = Comparator
			.comparing(Book::getNumberOfPages)
			.thenComparing(Book::getISBN);
	
	public static Comparator<Book> PAGE_ISBN_COMPARATOR = Comparator
			.comparing(Book::getNumberOfPages)
			.thenComparing(Comparator.comparing(Book::getISBN).reversed());
	
	public static Comparator<Book> PRICE_COMPARATOR = Comparator
			.comparing(Book::getPrice).reversed();
	
	public static Comparator<Book> RATING_PRICE_COMPARATOR = Comparator
			.comparing(Book::getRating).reversed()
			.thenComparing(Book::getPrice);
	
	
	private String title;
	private int ISBN;
	private double price;
	private int numberOfPages;
	private double rating;
	
	public Book(String title, int ISBN, double price, int numberOfPages, double rating) {
		this.title = title;
		this.ISBN = ISBN;
		this.price = price;
		this.numberOfPages = numberOfPages;
		this.rating = rating;
	}
	

	public String getTitle() {
		return this.title;
	}
	public int getISBN() {
		return this.ISBN;
	}
	public double getPrice() {
		return this.price;
	}
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	public double getRating() {
		return this.rating;
	}
	
	@Override
	public int compareTo(Book other) {
		// Compare titles as natural ordering
		return this.title.compareTo(other.getTitle());
	}
	
	@Override
	public String toString() {
		return this.getTitle() + ", " + this.getISBN() + ", " + this.getPrice() + ", " + this.getNumberOfPages() + ", " + this.getRating();
		
	}
	

}
