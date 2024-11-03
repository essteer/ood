package ood1.dependencies;

public class Memory {
	
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	private final double SPEED;
	
	public Memory(String model, double capacity, double speed) {
		this.MODEL = model;
		this.CAPACITY = capacity;
		this.SPEED = speed;
	}
	
	public static void storeData(String data) {
		System.out.println("storeData: data=" + data.toString());
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
	
	public double getSpeed() {
		return this.SPEED;
	}
	
	public void setUsedSpace(double spaceUsed) {
		this.usedSpace = spaceUsed;
	}

}
