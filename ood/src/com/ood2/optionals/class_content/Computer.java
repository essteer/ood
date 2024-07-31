package com.ood2.optionals.class_content;

import java.util.Optional;

public class Computer {
	String model;
	Motherboard motherboard;
	
	public Computer(String string) {
		setModel(string);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	// public Motherboard getMotherboard() {
	public Optional<Motherboard> getMotherboard() {	
		// return motherboard;
		return Optional.ofNullable(motherboard);
	}
	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}
}
