package com.ood2.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		Queue<String> queue = new PriorityQueue<>();
		queue.add("Keane");
		queue.add("KuanYi");
		queue.add("Yaodan");
		System.out.println(queue.poll());
		System.out.println(queue);
		
		Set<Integer> set = new TreeSet<>();
		set.add(5);
		set.add(3);
		set.add(8);
		set.add(6);
		set.add(2);
		set.add(5);
		set.add(10);
		System.out.println(set);
		
		Map<Character, Integer> map = convertWordToLetterFrequency("Alvin");
		System.out.println(map);
	}
	
	public static Map<Character, Integer> convertWordToLetterFrequency(String word) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		return map;
	}
	
	

}
