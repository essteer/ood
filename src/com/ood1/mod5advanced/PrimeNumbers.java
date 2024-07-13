package com.ood1.mod5advanced;

import java.util.ArrayList;

public class PrimeNumbers {

	public ArrayList<Integer> primeNumbers(int number) {

		ArrayList<Integer> primes = new ArrayList<>();

		if (number <= 1) {
			return primes;
		}
		primes.add(2);
		if (number == 2) {
			return primes;
		}
		primes.add(3);
		if (number == 3) {
			return primes;
		}

		for (int i = 4; i < number + 1; i++) {
			boolean isPrime = true;
			// Use copy to avoid modifying list being iterated through
			for (int p : new ArrayList<>(primes)) {
				if (i % p == 0) {
					// If current number divisible by
					// any preceding prime, it isn't prime
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}

		}
		return primes;
	}
}
