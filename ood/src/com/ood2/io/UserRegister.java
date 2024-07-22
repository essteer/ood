package com.ood2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegister {

	private String getName(Scanner scanner) {
		System.out.println("Name: ");
		return scanner.nextLine();
	}

	private String getCity(Scanner scanner) {
		System.out.println("City: ");
		return scanner.nextLine();
	}

	private String getEmail(Scanner scanner) {
		System.out.println("Email: ");
		return scanner.nextLine();
	}

	private void saveUser(String user) {

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./io_user_registry.txt", true));
			bufferedWriter.write(user);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void registerUser() {

		String userData = "";

		Scanner scanner = new Scanner(System.in);
		userData += this.getName(scanner);
		userData += ",";
		userData += this.getCity(scanner);
		userData += ",";
		userData += this.getEmail(scanner);
		scanner.close();

		this.saveUser(userData);
	}

	public List<User> createListOfUsersFromFile(String filepath) {

		List<User> userList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
			
            String line = bufferedReader.readLine();
     		
     		while (line != null) {
     			String[] userData = line.split(",");
     			User newUser = new User();
     			newUser.setName(userData[0]);
     			newUser.setCity(userData[1]);
     			newUser.setEmail(userData[2]);
     			userList.add(newUser);
     			line = bufferedReader.readLine();
     		}
     		bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList;
	}

}
