package com.ood2.optionals.class_content;

import java.util.Optional;
import java.util.function.Supplier;

public class Optionals {

	public static void main(String[] args) {
		String trainee = null;
		// String trainee = "Sandy";
		// If we don't expect trainee to ever be null
		// Optional<String> name = Optional.of(trainee);
		// In case we expect some null values, we can use the ofNullable() method
		Optional<String> name = Optional.ofNullable(trainee);
		Optional<String> empty = Optional.empty();

		// Using trainee directly
		System.out.println("Using 'trainee' and checking for null:");
		if (trainee != null)
			System.out.println("Hi " + trainee + "!");
		else
			System.out.println("Hello!");
		
		// Using name
		System.out.println("Using 'name' and using isPresent():");	
		if (name.isPresent()) {
			System.out.println("Hi " + name.get() + "!");
		} else {
			System.out.println("Hello!");
		}
		
		System.out.println("1. Hello " + trainee);
		System.out.println("2. Hello " + name.orElse("stranger!"));
		System.out.println("3. Hello " + empty.orElse("stranger!"));

		Computer myComputer = new Computer("HP");
		myComputer.getMotherboard()
				  .ifPresent(motherboard -> motherboard.getMemoryChip()
				  .ifPresent(memorychip -> memorychip.accessData()));							

		myComputer.getMotherboard()
		.orElse(new Motherboard("dummy motherboard"))
		.getMemoryChip()
	  	.orElse(new MemoryChip("dummy memory chip"))
		.accessData();
		
		Supplier<MotherboardException> supplyException =  
				() -> new MotherboardException("No motherboard present");

		try {
			myComputer.getMotherboard().orElseThrow(supplyException);
		} catch (MotherboardException e) {
			e.printStackTrace();
		}

	}
}
		

