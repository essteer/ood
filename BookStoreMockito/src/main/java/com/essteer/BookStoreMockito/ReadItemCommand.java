package com.essteer.BookStoreMockito;

import java.util.List;

public interface ReadItemCommand {
	
	List<Book> readAll();
	Book getItem(String id);

}
