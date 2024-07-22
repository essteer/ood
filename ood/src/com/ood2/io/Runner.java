package com.ood2.io;

import java.util.List;

public class Runner {

	public static void main(String[] args) {


//		String filepath = "./count_the_es.txt";
//		String characterToCount = "e";
//		
//		CharacterCounter characterCounter = new CharacterCounter();
//		int numberOfEsInFile = characterCounter.countCharacterInFile(characterToCount, filepath);
//		System.out.println(filepath.split("/")[1] + " contains " + numberOfEsInFile + " " + characterToCount + "'s.");
//		System.out.println();
		
		UserRegister userRegister = new UserRegister();
//		userRegister.registerUser();
		
		String userDataFilepath = "./io_user_registry.txt";
		List<User> userList = userRegister.createListOfUsersFromFile(userDataFilepath);
		
		for (User user : userList) {
			System.out.println(user.toString());
		}

	}

}
