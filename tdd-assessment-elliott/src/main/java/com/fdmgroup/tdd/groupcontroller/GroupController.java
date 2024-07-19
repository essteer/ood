package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public class GroupController implements GroupControllerService {
	
	private DatabaseReader dbReader;
	private DatabaseWriter dbWriter;
	
	public GroupController(DatabaseReader databaseReader, DatabaseWriter databaseWriter) {
		this.dbReader = databaseReader;
		this.dbWriter = databaseWriter;
	}
	
	@Override
	public Map<String, Trainee> getAllTrainees() {
		return this.dbReader.readGroup();
	}
	
	@Override
	public void removeTraineeByUsername(String traineeUsername) {
		this.dbWriter.deleteTraineeByUsername(traineeUsername);
	}
	
	@Override
	public void addTrainee(Trainee trainee) {
		this.dbWriter.addTrainee(trainee);
	}

}
