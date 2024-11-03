package ood1.dependencies;

import java.util.ArrayList;

public class ComputerStore {
	
	private String name;
	private ArrayList<Computer> computers;
	
	public ComputerStore(String name) {
		this.name = name;
		this.computers = new ArrayList<>();
	}
	
	public void addComputer(Computer computer) {
		this.computers.add(computer);
	}
	
	public ArrayList<Computer> getAllComputers() {
		return this.computers;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

}
