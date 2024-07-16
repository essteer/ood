package com.essteer.BookStoreMockito;

public interface WriteItemCommand {
	
	void insertItem(Book book);
	void deleteItem(Book book);

}
