package com.essteer.BookStoreTDD;

import java.util.ArrayList;

public class Basket {
	
	private ArrayList<Book> bookList;
	
	public Basket() {
		this.bookList = new ArrayList<>();
	}
	
	public ArrayList<Book> getBooksInBasket() {
		return this.bookList;
	}
	
	public void addBook(Book book) {
		this.bookList.add(book);
	}

}
