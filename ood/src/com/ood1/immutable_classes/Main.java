package com.ood1.immutable_classes;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Trainee trainee1 = new Trainee("Alan", "Data", 3);
		Trainee trainee2 = new Trainee("Bree", "BA", 3);
		Trainee trainee3 = new Trainee("Carl", "Software", 3);
		
		ArrayList<Trainee> trainees = new ArrayList<>();
		trainees.add(trainee1);
		trainees.add(trainee2);
		trainees.add(trainee3);
		
		Trainer trainer1 = new Trainer("Dion");
		trainer1.addStream("Data");
		trainer1.addStream("BA");
		trainer1.addStream("Software");
		
		CompletedClass completedClass = new CompletedClass("Program", trainer1, trainee1, trainee2, trainee3);
		trainee1.setWeek(100);
		trainee2.setWeek(100);
		trainee3.setWeek(100);
		
		ArrayList<Trainee> calledTrainees = completedClass.getTrainees();
		
		for (Trainee t : calledTrainees) {
			System.out.println(t.getWeek());
		}
		
		trainer1.addStream("Maths");
		
		Trainer calledTrainer = completedClass.getTrainer();
		
		for (String stream : calledTrainer.getAllStreams()) {
			System.out.println(stream);
		}
		

	}

}
