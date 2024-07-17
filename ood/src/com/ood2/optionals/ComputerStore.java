package com.ood2.optionals;

import java.util.List;
import java.util.Optional;

public class ComputerStore {
	
	List<Computer> computers;
	private String name;
	
	public ComputerStore(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<List<Computer>> getComputers() {
		return Optional.ofNullable(computers);
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	@Override
	public String toString() {
		return "ComputerStore [computers=" + computers + ", name=" + name + "]";
	}
	
}
