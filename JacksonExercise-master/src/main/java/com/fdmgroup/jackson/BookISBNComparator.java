package com.fdmgroup.jackson;

import java.util.Comparator;

public class BookISBNComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		return bookA.getIsbn().compareTo(bookB.getIsbn());
	}

}
