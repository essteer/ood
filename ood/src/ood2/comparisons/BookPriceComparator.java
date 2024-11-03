package ood2.comparisons;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
	
	@Override
	public int compare(Book bookA, Book bookB) {
		// Sort by price in descending order
//		return Double.compare(bookB.getPrice(), bookA.getPrice());
		return (int) (bookB.getPrice() - bookA.getPrice());
		
	}

}
