package ood2.threading;

import java.util.concurrent.ThreadLocalRandom;

public class Runner {

	public static void main(String[] args) {
		
//		ThreadManager threadManager = new ThreadManager();
		ThreadManagerChild threadManager = new ThreadManagerChild();
//		ThreadManagerChildLambda threadManager = new ThreadManagerChildLambda();
		
		int randomNumber = ThreadLocalRandom.current().nextInt(3, 11);
		System.out.println(String.format("Generating %s threads", randomNumber));
		
		threadManager.createThreads(randomNumber);
		threadManager.runThreads();
		
		

	}

}
