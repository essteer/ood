package com.essteer.BookStoreTDD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Checkout {

	public double calculatePrice(Basket basket) {

		double totalPrice = 0.0;
		boolean allBooksAreUnique = true;
		ArrayList<Long> basketISBNs = new ArrayList<>();

		for (Book book : basket.getBooksInBasket()) {
			totalPrice += book.getPrice();

			if (basketISBNs.contains(book.getISBN())) {
				allBooksAreUnique = false;
			}
			basketISBNs.add(book.getISBN());
		}

		// 1% discount per 3 books in basket
		int multiplesOfThree = Math.floorDiv(basket.getBooksInBasket().size(), 3);
		double discountPerThreeBooks = 0.01 * multiplesOfThree;

		double discountMultiplier = 1 - discountPerThreeBooks;

		// 10% discount if 10 or more books in basket
		int mininumNumBooksForDiscountToApply = 10;
		boolean tenOrMoreBooks = basket.getBooksInBasket().size() >= mininumNumBooksForDiscountToApply;
		if (tenOrMoreBooks) {
			discountMultiplier -= 0.1;
		}

		// 5% discount if all books have unique ISBNs
		if (basket.getBooksInBasket().size() > 1) {
			double discountIfAllBooksHaveUniqueISBNs = 0.05;
			if (allBooksAreUnique) {
				discountMultiplier -= discountIfAllBooksHaveUniqueISBNs;
			}
		}
		

		double discountedTotalPrice = totalPrice * discountMultiplier;

		// Further 50% discount for 2 books if 2 or more of same book are present
		// E.g., 1) A, 2) A, 3) A, 4) B -> 1) and 2) get a 50% discount each
		if (!allBooksAreUnique) {
			ArrayList<Long> allBookISBNs = new ArrayList<>();
			Set<Book> duplicateBooks = new HashSet<>();

			for (Book book : basket.getBooksInBasket()) {
				if (allBookISBNs.contains(book.getISBN())) {
					if (!duplicateBooks.contains(book)) {
						duplicateBooks.add(book);
					}
				}
				allBookISBNs.add(book.getISBN());
			}

			for (Book duplicateBook : duplicateBooks) {
				discountedTotalPrice -= duplicateBook.getPrice();
			}
		}

		return discountedTotalPrice;
	}

}
