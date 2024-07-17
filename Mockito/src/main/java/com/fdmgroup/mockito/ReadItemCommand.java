package com.fdmgroup.mockito;

import java.util.List;

public interface ReadItemCommand {

	List<Book> readAll();

	Book getItem(String id);

}
