package com.ood2.designpattern;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;
    
    public Library() {
    	this.availableBooks = new ArrayList<>();
    	this.borrowedBooks = new ArrayList<>();
    }
    
    public void addAvailableBooks() {
    	
    }

}
