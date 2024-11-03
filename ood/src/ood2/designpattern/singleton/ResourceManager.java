package ood2.designpattern.singleton;

public class ResourceManager {

	public static void main(String[] args) {		
		// Initialization of PrintSpooler
		// PrintSpooler spooler = new PrintSpooler();
		PrintSpooler spooler = PrintSpooler.getInstance();
		
		// Do work with spooler here
		spooler.work();
	}
}
