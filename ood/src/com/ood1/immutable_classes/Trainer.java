package com.ood1.immutable_classes;

import java.util.ArrayList;

public class Trainer {
	
	private String name;
	private ArrayList<String> streamsTaught;
	
	public Trainer(String name) {
		this.name = name;
		this.streamsTaught = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStream(String stream) {
		this.streamsTaught.add(stream);
	}
	
	public ArrayList<String> getAllStreams() {
		return this.streamsTaught;
	}
	

}
