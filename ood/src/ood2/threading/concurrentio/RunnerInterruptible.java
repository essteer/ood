package ood2.threading.concurrentio;

public class RunnerInterruptible {

	public static void main(String[] args) {

		AverageCalculator averageCalc = new AverageCalculator();

		// Run GenerateNumberFiles.java to get these files
		String largeFileName1 = "./resources/records1.txt";
		String largeFileName2 = "./resources/records2.txt";
		FileReaderThread fileReaderThread1 = new FileReaderThread(averageCalc, largeFileName1);
		FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalc, largeFileName2);

		System.out.println("Application started...");

		fileReaderThread1.start();
		fileReaderThread2.start();

		Thread currentTotalThread = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running...");
				while (true) {
					try {
						System.out.println("Total: " + averageCalc.getTotal() + "\nCount: " + averageCalc.getCount());
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			}
		}, "currentTotalThread");
		currentTotalThread.start();
		
		try {
			fileReaderThread1.join();			
			fileReaderThread2.join();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		currentTotalThread.interrupt();
		
		System.out.println("Total: " + averageCalc.getTotal());
		System.out.println("Count: " + averageCalc.getCount());
		System.out.println("Average: " + averageCalc.calculateAverage());

	}
}
