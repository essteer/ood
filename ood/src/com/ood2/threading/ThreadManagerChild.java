package com.ood2.threading;

public class ThreadManagerChild extends ThreadManager {

	@Override
	public void createThreads(int number) {
		if (number > 0) {
			for (int i=1; i <= number; i++) {
				Thread thread = new Thread(new Runnable(){
					public void run() {
						System.out.println(Thread.currentThread().getName());
					}
				}, "threadChild" + i);
				thread.start();
			}
		}
	}
}
