package com.ood2.threading;

public class MyRunnable implements Runnable {
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
