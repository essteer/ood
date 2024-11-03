package ood2.threading;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
	
	protected List<Thread> threads;
	
	public ThreadManager() {
		this.threads = new ArrayList<>();
	}
	
	public void createThreads(int number) {
		if (number > 0) {
			for (int i=1; i <= number; i++) {
				MyRunnable myRunnable = new MyRunnable();
				Thread thread = new Thread(myRunnable);
				thread.setName("thread" + i);
				this.threads.add(thread);
			}
		}
	}
	
	public void runThreads() {
		if (!this.threads.isEmpty()) {
			for (Thread thread : this.threads) {
				thread.start();
			}
		}
	}

}
