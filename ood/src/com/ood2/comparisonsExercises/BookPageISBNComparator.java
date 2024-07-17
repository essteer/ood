package com.ood2.comparisonsExercises;

import java.util.Comparator;

public class BookPageISBNComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort by ascending number of pages
		// int comparison = Integer.compare(bookA.getNumberOfPages(), bookB.getNumberOfPages());
		int comparison = bookA.getNumberOfPages() - bookB.getNumberOfPages();
		
		if (comparison == 0) {
			// If the books have the same number of pages
			// sort by descending ISBN number -> so compare B then A
			// return Integer.compare(bookB.getISBN(), bookA.getISBN());
			return bookB.getISBN() - bookA.getISBN();
		}
		// Otherwise, return page number comparison
		return comparison;
	}

}
