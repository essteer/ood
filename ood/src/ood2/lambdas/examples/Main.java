package ood2.lambdas.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(i);
		}
		System.out.println(filterOdd(nums));
		System.out.println(filterOddLambda(nums));
	}

	public static List<Integer> filterOdd(List<Integer> nums) {
		List<Integer> odds = new ArrayList<>();
		for (int num : nums) {
			if (num % 2 != 0) {
				odds.add(num);
			}
		}
		return odds;
	}

	public static List<Integer> filterOddLambda(List<Integer> nums) {
		return nums.stream()
				.filter(i -> i % 2 != 0)
				.filter(i -> i > 5)
				.collect(Collectors.toList());
	}

}
