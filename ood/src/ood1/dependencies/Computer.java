package ood1.dependencies;

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

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public String getMODEL() {
		return MODEL;
	}

	public Processor getPROCESSOR() {
		return PROCESSOR;
	}

}
