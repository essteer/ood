package com.ood2.threading;

public class ThreadManagerChildLambda extends ThreadManager {
	
	@Override
	public void createThreads(int number) {
		if (number > 0) {
			for (int i=1; i <= number; i++) {
				Thread thread = new Thread(() -> {
						System.out.println(Thread.currentThread().getName());
				}, "threadChildLambda" + i);
				thread.start();
			}
		}
	}

}
