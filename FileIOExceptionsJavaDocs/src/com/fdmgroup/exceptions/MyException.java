package com.fdmgroup.exceptions;

/**
 * 
 * @author Itai Ndoro
 * my custom exception
 */
public class MyException extends Exception {

	/**
	 * creates a MyException with message 'My very descriptive exception message'
	 */
	public MyException() {
		super("CustomExceptionMessage: My very descriptive exception message");
	}
}
