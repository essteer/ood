package com.fdmgroup.singleton;

public class PrintSpooler {
	
	private static PrintSpooler spooler; // Only instance
	
	private static boolean initialized = false;
	
	private PrintSpooler() {} // Prevents using the new keyword 
	
	private void init() {
		// To do - code to initialize details for print spooler
		// This code could also be in the constructor
	}
	public void work() {
		System.out.println("Doing some spooler work");
	}

	public static PrintSpooler getInstance() {
		if (initialized) return spooler;
		spooler = new PrintSpooler();
		spooler.init();
		initialized = true;
		return spooler;
	}
}
