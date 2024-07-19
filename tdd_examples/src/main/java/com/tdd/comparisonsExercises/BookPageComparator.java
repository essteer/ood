package com.tdd.comparisonsExercises;

import java.util.Comparator;

public class BookPageComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort by ascending number of pages
		// int comparison = Integer.compare(bookA.getNumberOfPages(), bookB.getNumberOfPages());
		int comparison = bookA.getNumberOfPages() - bookB.getNumberOfPages();
		
		if (comparison == 0) {
			// If the books have the same number of pages
			// sort by ascending ISBN number
//			return Integer.compare(bookA.getISBN(), bookB.getISBN());
			return bookA.getISBN() - bookB.getISBN();
		}
		// Otherwise, return page number comparison
		return comparison;
	}

}
