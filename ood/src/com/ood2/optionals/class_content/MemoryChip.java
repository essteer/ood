package com.ood2.optionals.class_content;

public class MemoryChip {
	String model;
	
	public MemoryChip(String string) {
		setModel(string);
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void accessData() {
		System.out.println("Memory Chip : " + model);
	}
}
