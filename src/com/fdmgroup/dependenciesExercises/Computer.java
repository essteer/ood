package com.fdmgroup.dependenciesExercises;

public class Computer {
	
	private final String MODEL;
	private HardDrive hardDrive;
	private Memory memory;
	private final Processor PROCESSOR;
	
	public Computer(String model, HardDrive hardDrive, Memory memory, Processor processor) {
		this.MODEL = model;
		this.hardDrive = hardDrive;
		this.memory = memory;
		this.PROCESSOR = processor;
	}
	
	public void turnOn() {
	}
	
	public void turnOff() {
	}
	
	public void getPower(PowerSource powerSource) {
		double power = powerSource.supplyPower();
		System.out.println(power + " watts received from power source");
	}
	
	
	

}
