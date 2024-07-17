package com.tdd.demo.comparisonsExercises;

import java.util.Comparator;

public class BookRatingPriceComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort by descending rating, so compare bookB first
        int ratingComparison = Double.compare(bookB.getRating(), bookA.getRating());
        if (ratingComparison != 0) {
        	// Sort by highest rating first
            return ratingComparison; 
        }
        // Sort by lowest price if ratings are equal, so compare bookA first
        return Double.compare(bookA.getPrice(), bookB.getPrice()); 
    }
			

}
