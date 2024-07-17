package com.ood1.dependenciesExercises;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		
		HardDrive drive1 = new HardDrive("Seagate", 2048);
		HardDrive drive2 = new HardDrive("Dell", 3072, 500);
		
		Processor processor1 = new Processor("Intel Xeon", 2.93, 6);
		Processor processor2 = new Processor("Intel Celeron", 2.9, 2);
		
		Memory memory1 = new Memory("Kingston", 4, 1600);
		Memory memory2 = new Memory("Corsair", 8, 1333);
		
		System.out.println(drive1.getModel());
		System.out.println(drive1.getCapacity());
		System.out.println(drive1.getUsedSpace());
		System.out.println();
		System.out.println(drive2.getModel());
		System.out.println(drive2.getCapacity());
		System.out.println(drive2.getUsedSpace());
		System.out.println();
		System.out.println(processor1.getModel());
		System.out.println(processor1.getNumberOfCores());
		System.out.println(processor1.getSpeed());
		System.out.println();
		System.out.println(processor2.getModel());
		System.out.println(processor2.getNumberOfCores());
		System.out.println(processor2.getSpeed());
		System.out.println();
		System.out.println(memory1.getModel());
		System.out.println(memory1.getCapacity());
		System.out.println(memory1.getSpeed());
		System.out.println();
		System.out.println(memory2.getModel());
		System.out.println(memory2.getCapacity());
		System.out.println(memory2.getSpeed());
		
		Computer computer1 = new Computer("Dell", drive1, memory1, processor1);
		Computer computer2 = new Computer("Lenovo", drive2, memory2, processor2);
		
		PowerSource powerSource1 = new PowerSource();
		powerSource1.setWatts(567);
		computer1.getPower(powerSource1);
		
		PowerSource powerSource2 = new PowerSource();
		powerSource2.setWatts(890);
		computer2.getPower(powerSource2);
		
		ComputerStore computerStore = new ComputerStore("PC Land");
		computerStore.addComputer(computer1);
		computerStore.addComputer(computer2);
		
		ArrayList<Computer> computerList = computerStore.getAllComputers();
		for (Computer c : computerList) {
			System.out.println(c);
		}

	}

}
