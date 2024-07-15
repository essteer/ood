package com.ood2.optionals;

public class Memory {
	
	private String model;
	
	
	
	public Memory(String model) {
		super();
		this.model = model;
	}



	@Override
	public String toString() {
		return "Memory [model=" + model + "]";
	}



	public void accessData() {
		System.out.println("accessing data");
	}

}
