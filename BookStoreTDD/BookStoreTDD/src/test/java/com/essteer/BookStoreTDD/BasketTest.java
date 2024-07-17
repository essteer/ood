package com.essteer.BookStoreTDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BasketTest {

	@Test
	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() {
		Basket basket = new Basket();
		int expected = 0;
		int actual = basket.getBooksInBasket().size();
		assertEquals(expected, actual);
	}

	@Test
	public void test_getBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		Basket basket = new Basket();
		Book book = new Book(0.0);
		basket.addBook(book);
		int expected = 1;
		int actual = basket.getBooksInBasket().size();
		assertEquals(expected, actual);
	}

	@Test
	public void test_getBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBooks() {
		Basket basket = new Basket();
		Book book1 = new Book(0.0);
		basket.addBook(book1);
		Book book2 = new Book(0.0);
		basket.addBook(book2);
		int expected = 2;
		int actual = basket.getBooksInBasket().size();
		assertEquals(expected, actual);
	}

}
