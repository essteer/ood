package com.essteer.BookStoreMockito;

import java.util.List;

public class Catalogue {
	
	private ReadItemCommand ric;
	private WriteItemCommand wic;
	
	public Catalogue(ReadItemCommand ric, WriteItemCommand wic) {
		this.ric = ric;
		this.wic = wic;
	}
	
	public List<Book> getAllBooks() {
		return this.ric.readAll();
	}
	
	public void addBook(Book book) {
		this.wic.insertItem(book);
	}
	
	public void addBooks(List<Book> books) {
		for (Book book : books) {
			this.wic.insertItem(book);
		}
	}
	
	public Book getBook(String isbn) {
		return new Book(isbn);
	}
	
	public void deleteBook(Book book) {
		this.wic.deleteItem(book);
	}
	
	public void deleteAllBooks() {
		List<Book> allBooks = this.ric.readAll();
		for (Book book : allBooks) {
			this.wic.deleteItem(book);
		}
	}

}
