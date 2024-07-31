package com.ood1.classes_objects;

public class HardDrive {
	
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	
	public HardDrive(String model, double capacity) {
		this.MODEL = model;
		this.CAPACITY = capacity;
		this.usedSpace = 0.0;
	}
	
	public HardDrive(String model, double capacity, double spaceUsed) {
		this.MODEL = model;
		this.CAPACITY = capacity;
		this.usedSpace = spaceUsed;
	}
	
	public static String readData(String file) {
		return "data from " + file;
	}
	
	public static void writeData(String data, String file) {
		System.out.println("writeData: data=" + data + ", file=" + file);
	}
	
	public String getModel() {
		return this.MODEL;
	}
	
	public double getCapacity() {
		return this.CAPACITY;
	}
	
	public double getUsedSpace() {
		return this.usedSpace;
	}
	
	public void setUsedSpace(double spaceUsed) {
		this.usedSpace = spaceUsed;
	}

}
