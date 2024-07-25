package com.ood2.solid;

public interface Account {
	
	int getAccountNumber();
	String getAccountName();
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);

}
