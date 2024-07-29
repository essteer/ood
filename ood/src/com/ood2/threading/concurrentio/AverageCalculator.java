package com.ood2.threading.concurrentio;

public class AverageCalculator {
	
	private long total;
	private long count;
	
	public long getTotal() {
		return this.total;
	}
	
	public long getCount() {
		return this.count;
	}
	
	public synchronized void addToTotal(int number) {
		this.total += number;
		this.count++;
	}
	
	public double calculateAverage() {
		return this.total / this.count;
	}

}
