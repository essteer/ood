package com.tdd.comparisonsExercises;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort alphabetically, so bookA then bookB for ascending order
		return bookA.getTitle().compareTo(bookB.getTitle());
	}

}
