package com.ood2.threading.concurrentio;

public class Runner {

	public static void main(String[] args) {

		AverageCalculator averageCalc = new AverageCalculator();

		// String fileName = "./resources/TestRecords.txt";
		// FileReaderThread fileReaderThread = new FileReaderThread(averageCalc, fileName);
		
		String largeFileName1 = "./resources/records1.txt";
		String largeFileName2 = "./resources/records2.txt";
		FileReaderThread fileReaderThread1 = new FileReaderThread(averageCalc, largeFileName1);
		FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalc, largeFileName2);
		
		System.out.println("Application started...");
		
		// fileReaderThread.start();
		fileReaderThread1.start();
		fileReaderThread2.start();
		
		try {
			// fileReaderThread.join();
			fileReaderThread1.join();			
			fileReaderThread2.join();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total: " + averageCalc.getTotal());
		System.out.println("Count: " + averageCalc.getCount());
		System.out.println("Average: " + averageCalc.calculateAverage());

	}

}
