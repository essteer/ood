package ood2.streams.class_content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Countries {
	// Requirement:
	
	// 1. Capitalize all the country names
	// 2. Filter out country names starting with a 'C'
	// 3. Sort the countries by alphabetical order
	// 4. Print the result of 1-3 to the console
	
	public static void main(String[] args) {
		ArrayList<String> countries = new ArrayList<String>
									(Arrays.asList("United States", 
											"China", 
											"United Kingdom", 
											"South Africa", 
											"Zimbabwe",
											"Zambia", 
											"Canada",
											"New Zealand", 
											"Singapore",
											"Japan", 
											"Indonesia", 
											"Thailand", 
											"Brazil", 
											"Germany",
											"Mexico",
											"Crotia"));
		// Without using Streams API
		Collections.sort(countries); // Requirement #3
		for (String country : countries) {
			country = country.toUpperCase(); // Requirement #1
			if (!country.startsWith("C")) { // Requirement #2
				System.out.println(country); // Requirement #4				
			}
		}
		
		// Using Streams API
//		countries.stream() // Create our sequence of objects
//				 .map(s -> s.toUpperCase()) // Requirement #1
//				 .filter(s -> !s.startsWith("C")) // Requirement #2
//				 .sorted() // Requirement #3
//				 .forEach(s -> System.out.println(s)); // Requirement #4
//
		countries.stream().map(s -> s.toUpperCase()).filter(s -> !s.startsWith("C")).sorted().forEach(s -> System.out.println(s));

	}
}	
	
	
	
	
	
	
	
/* 
 * JAVA
 * 1. Java code *.java
 * 2. Java Compiler - javac. Takes the .java file and compiles it into bytecode *.class
 * 3. JVM (java) takes the bytecode *.class and interpret it to machine code
 * 4. The machine code runs on the Operating system and hardware (CPU).
 * 
 * C++
 * 1. *.cpp *.c++
 * 2. g++ compiles the C++ to machine code
 * 3. Run machine code directly (no "Virtual machine")
 * 
 */
