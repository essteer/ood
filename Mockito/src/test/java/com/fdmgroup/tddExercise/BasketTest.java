package com.fdmgroup.tddExercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class BasketTest {

	@Test
	void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() {
		// Arrange
		Basket basket = new Basket();

		// Act
		List<Book> listOfBooks = basket.getBooksInBasket();

		// Assert
		assertEquals(0, listOfBooks.size());
	}

	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book();

		// Act
		basket.addBook(book);
		List<Book> listOfBooks = basket.getBooksInBasket();

		// Assert
		assertEquals(1, listOfBooks.size());
	}

	@Test
	public void test3() {
		// Arrange
		Basket basket = new Basket();
		Book book = new Book();

		// Act
		basket.addBook(book);
		basket.addBook(book);
		List<Book> listOfBooks = basket.getBooksInBasket();

		// Assert
		assertEquals(2, listOfBooks.size());
	}

}
