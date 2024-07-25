package com.ood2.solid;

public class OverdraftAccountImpl extends BasicAccount implements OverdraftAccount {
	
	private double overdraftLimit;
	
	public OverdraftAccountImpl(int accountNumber, String accountName, int pin) {
		super(accountNumber, accountName, pin);
	}
	
	@Override
	public boolean hasOverdraft() {
		return overdraftLimit > 0;
	}
	
	@Override
	public void setOverdraftLimit(double limit) {
		this.overdraftLimit = limit;
	}
	
	@Override
	public void withdraw(double amount) {
		if (this.getBalance() + this.overdraftLimit >= amount) {
			super.withdraw(amount);
		} else {
			throw new IllegalArgumentException("Overdraft limit exceeded");
		}
	}
	
}
