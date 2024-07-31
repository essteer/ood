package com.ood1.classes_objects;

public class Processor {
	
	private final String MODEL;
	private final double SPEED;
	private final int NUMBER_OF_CORES;
	
	public Processor(String Model, double speed, int numberOfCores) {
		this.MODEL = Model;
		this.SPEED = speed;
		this.NUMBER_OF_CORES = numberOfCores;
	}
	
	public static void processData(String data) {
		System.out.println("processData: data=" + data.toString());
	}
	
	public String getModel() {
		return this.MODEL;
	}
	
	public double getSpeed() {
		return this.SPEED;
	}
	
	public int getNumberOfCores() {
		return this.NUMBER_OF_CORES;
	}

}
