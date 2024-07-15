//package com.ood2.collections;
//
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class QueueDemo {
//	
//	public static void main(String[] args) {
//		
//		Queue<String> waitList = new LinkedList<>();
//		waitList.add("Audrey, party of one");
//		waitList.add("Steve, party of five");
//		waitList.add("Sam, party of two");
//		
//		System.out.println(waitList);
//		System.out.println(waitList.peek());
//		
//		// Retrieve and remove first object in list
//		System.out.println(waitList.poll());
//		
//		System.out.println(waitList);
//		
//		// Add rule in constructor on how to prioritise
//		Queue<Person> priorityWaitList = new PriorityQueue<>(new FriendComparator());
//		
//		Person audrey = new Person("Audrey", false);
//		Person daniel = new Person("Daniel", true);
//		Person roger = new Person("Roger", false);
//		priorityWaitList.add(audrey);
//		priorityWaitList.add(roger);
//		// Would print Audrey
//		System.out.println(priorityWaitList.peek());
//		priorityWaitList.add(daniel);
//		// Would print Daniel
//		System.out.println(priorityWaitList.peek());
//	}
//
//}
