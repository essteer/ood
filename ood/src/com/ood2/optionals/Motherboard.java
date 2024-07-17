package com.ood2.optionals;

import java.util.Optional;

public class Motherboard {
	
	private String Model;
	private Memory memory;
	
	public Motherboard(String model) {
		this.Model = model;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Optional<Memory> getMemory() {
		// if null, an empty Optional is returned instead of null
		return Optional.ofNullable(memory);
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "Motherboard [Model=" + Model + ", memory=" + memory + "]";
	}

}
