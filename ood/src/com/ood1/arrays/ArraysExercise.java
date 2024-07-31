package com.ood1.arrays;

import java.util.Arrays;

public class ArraysExercise {

	public static void main(String[] args) {
		String[] friends = {"bob", "alice", "cindy", "dave", "eric"};
		for (int i=0; i<friends.length; i++) {
			System.out.println(friends[i]);
		}
		friends[4] = "brian";
		Arrays.sort(friends);
		System.out.println(friends[0]);
		System.out.println(friends[4]);
		friends[1] = null;
		
		
		String[] pokerHand = new String[5];
		pokerHand[0] = "Queen of hearts";
		pokerHand[1] = "3 of spades";
		pokerHand[2] = "3 of diamonds";
		pokerHand[3] = "9 of hearts";
		pokerHand[4] = "6 of clubs";

	}

}
