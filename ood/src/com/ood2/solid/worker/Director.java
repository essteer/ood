package com.ood2.solid.worker;

import java.util.ArrayList;
import java.util.List;

public class Director {
	
private List<Worker> workerReports;
	
	public Director() {
		this.workerReports = new ArrayList<>();
	}
	
	public void addWorker(Worker worker) {
		this.workerReports.add(worker);
	}
	
	public List<Worker> getWorkers() {
		return this.workerReports;
	}

}
