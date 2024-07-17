package com.fdmgroup.tddExercise;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	
	private List<Book> listOfBooks;
	
	public Basket() {
		listOfBooks = new ArrayList<>();
	}

	public List<Book> getBooksInBasket() {
		return listOfBooks;
	}

	public void addBook(Book book) {
		listOfBooks.add(book);		
	}

}
