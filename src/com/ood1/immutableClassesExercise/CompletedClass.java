package com.ood1.immutableClassesExercise;

import java.util.ArrayList;

final class CompletedClass {
	
	private final String SUBJECT;
	private final Trainer TRAINER;
	private final ArrayList<Trainee> TRAINEES;
	
	public CompletedClass(String subject, Trainer trainer, Trainee... trainee) {
		this.SUBJECT = subject;
		
		// Make defensive copies of trainer and trainees
		Trainer finalTrainer = new Trainer(trainer.getName());
		for (String stream : trainer.getAllStreams()) {
			finalTrainer.addStream(stream);
		}
		this.TRAINER = finalTrainer;
		
		ArrayList<Trainee> traineeList = new ArrayList<>();
		for (Trainee t : trainee) {
		    String tName = t.getName();
		    String tStream = t.getStream();
		    int tWeek = t.getWeek();
		    Trainee finalTrainee = new Trainee(tName, tStream, tWeek);
		    traineeList.add(finalTrainee);
		}
		this.TRAINEES = traineeList;
		
	}

	public String getSubject() {
		return SUBJECT;
	}

	public Trainer getTrainer() {
		return TRAINER;
	}

	public ArrayList<Trainee> getTrainees() {
		return TRAINEES;
	}
	
	

}
