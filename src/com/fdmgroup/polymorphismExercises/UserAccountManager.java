package com.fdmgroup.polymorphismExercises;

import java.util.ArrayList;

public class UserAccountManager {
	
	private ArrayList<UserAccount> userAccounts;
	
	public UserAccountManager() {
		this.userAccounts = new ArrayList<>();
	}
	
	public void addUser(UserAccount user) {
		this.userAccounts.add(user);
	}
	
	public boolean login(String username, String password) {
		
		for (UserAccount userAccount : this.userAccounts) {
			if (username.equals(userAccount.getUsername()) &&
			    password.equals(userAccount.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
