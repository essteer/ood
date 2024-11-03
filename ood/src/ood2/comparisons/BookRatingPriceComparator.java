package ood2.comparisons;

import java.util.Comparator;

public class BookRatingPriceComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort by descending rating, so compare bookB first
        int ratingComparison = Double.compare(bookB.getRating(), bookA.getRating());
        
        // below method doesn't work
        // int ratingComparison = (int) (bookA.getRating() - bookB.getRating());
        
        if (ratingComparison != 0) {
        	// Sort by highest rating first
            return ratingComparison; 
        }
        // Sort by ascending price if ratings are equal, so compare bookA first
        return Double.compare(bookA.getPrice(), bookB.getPrice());
        
        // below method doesn't work
        // return (int) (bookA.getPrice() - bookB.getPrice());
    }
			

}
