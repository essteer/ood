package ood2.solid;

public class BasicAccount implements Account {
	
	private final int accountNumber;
	private String accountName;
	private double balance;
	private int PIN;
	
	public BasicAccount(int accountNumber, String accountName, int pin) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
	    this.balance = 0.0;
	    this.PIN = pin;
	}
	
	@Override
	public int getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}
	
	public void setPIN(int oldPin, int pin) {
		if (this.PIN == oldPin) {
			this.PIN = pin;
		}
	}

	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		if (this.balance - amount >= 0) {
			this.balance -= amount;
		}
	}

}
