package com.ood2.solid;

public class InterestBearingAccountImpl extends BasicAccount implements InterestBearingAccount {
	
	private double interestRate;
	
	public InterestBearingAccountImpl(int accountNumber, String accountName, int pin, double interestRate) {
		super(accountNumber, accountName, pin);
		this.interestRate = interestRate;
	}

	
	@Override
	public double calculateInterest() {
		return this.getBalance() * interestRate;
	}
	
	@Override
	public void applyInterest() {
		deposit(calculateInterest());
	}
}
