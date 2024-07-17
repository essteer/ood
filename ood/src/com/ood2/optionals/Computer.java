package com.ood2.optionals;

import java.util.Optional;

public class Computer {

	private String model;
	private Motherboard motherboard;

	public Computer(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Optional<Motherboard> getMotherboard() {
		// if null, an empty Optional is returned instead of null
		return Optional.ofNullable(motherboard);
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	@Override
	public String toString() {
		return "Computer [model=" + model + ", motherboard=" + motherboard + "]";
	}
	
	

}
