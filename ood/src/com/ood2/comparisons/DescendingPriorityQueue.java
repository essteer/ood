package com.ood2.comparisons;

import java.util.Collections;
import java.util.PriorityQueue;

public class DescendingPriorityQueue {
	
	public static PriorityQueue<Double> getDescendingPriorityQueue(double... values) {
		
		PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for (double value : values) {
			priorityQueue.add(value);
		}
		
		return priorityQueue;
	}

}
