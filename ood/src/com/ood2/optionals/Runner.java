package com.ood2.optionals;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Runner {

	public static void main(String[] args) {
		
		Computer computer = new Computer("HP");
		
		// pre-Java 8 defensive code to check for nulls
		// (prior to introduction of Optionals)
//		if (computer.getMotherboard() != null) {
//			computer.getMotherboard().getMemory();
//			if (computer.getMotherboard().getMemory() != null) {
//				computer.getMotherboard().getMemory().accessData();
//			}
//		}
		
		computer.setMotherboard(new Motherboard("Gigabyte"));
		
		Optional<Motherboard> optionalMotherboard = computer.getMotherboard();
		// the get() method should never be called without the isPresent() method
//		if (optionalMotherboard.isPresent()) {
//			Motherboard motherboard = optionalMotherboard.get();
//		}
		
		// Optional methods: ifPresent() allows us to call a method on an
		// object within an Optional
		Consumer<Motherboard> printMotherboardModel = 
				motherboard -> System.out.println(motherboard.getModel());
			
		computer.getMotherboard()
		// if the motherboard is present, then it will call the method on the object
		    .ifPresent(printMotherboardModel);
		// this guarantees that a null pointer exception will not arise
		
		Memory memory1 = new Memory("DDR");
		computer.getMotherboard()
		    .ifPresent(motherboard -> motherboard.setMemory(memory1));
		
		computer.getMotherboard()
		    .ifPresent(motherboard -> motherboard.getMemory()
		    .ifPresent(memory -> memory.accessData()));
		
		
		// Optional Methods: orElse() allows us to replace a null value
		// within an Optional with a dummy value
		
		ComputerStore computerStore = new ComputerStore("Okay-Buy");
		
		// if there are no computers to get, pass a new list and call size() on it
		Optional<List<Computer>> numberOfComputers = computerStore.getComputers();
//		    .orElse(new ArrayList<Computer>())
//		    .size();
		
		// will print 0, because the size of an empty ArrayList is 0
		System.out.println(numberOfComputers);
		// if we didn't use orElse(), we would have got nothing in return
		
		Supplier<MissingMotherboardException> missingMotherboard = 
				() -> new MissingMotherboardException("missing motherboard");
		
		Supplier<MissingMemoryException> missingMemory = 
				() -> new MissingMemoryException("missing memory");	
		
		try {
			computer.getMotherboard()
		    .orElseThrow(missingMotherboard)
		    .getMemory()
		    .orElseThrow(missingMemory)
		    .accessData();
			
		} catch (MissingMemoryException e) {
			e.printStackTrace();
		} catch (MissingMotherboardException e) {
			e.printStackTrace();
		}
		
		
		// Optional Types
		OptionalInt optionalInt = OptionalInt.empty();
		if (optionalInt.isPresent()) {
			System.out.println(computerStore.getName() + " has " + 
		    optionalInt.getAsInt() + " computers for purchase.");
		} else {
			System.out.println(computerStore.getName() + " has no computers.");
		}

	}

}
