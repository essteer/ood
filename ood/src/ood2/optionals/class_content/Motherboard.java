package ood2.optionals.class_content;

import java.util.Optional;

public class Motherboard {
	String model;
	MemoryChip memoryChip;
	
	public Motherboard(String string) {
		setModel(string);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Optional<MemoryChip> getMemoryChip() {
		return Optional.ofNullable(memoryChip);
	}
	public void setMemoryChip(MemoryChip memoryChip) {
		this.memoryChip = memoryChip;
	}
}
