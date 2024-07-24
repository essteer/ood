package com.ood2.javadoc;

/**
 * See {@link com.ood2.javadoc.InvalidAccountException} for exception documentation
 */
public class BankAccount {

	private final int accountNumber;
	private String accountName;
	private double balance;

	/**
	 * 
	 * @param accountNumber the unique number associated with the account
	 * @param accountName the name associated with the account
	 * @param balance the current balance of the account
	 */
	public BankAccount(int accountNumber, String accountName, double balance) {
		this.accountNumber = accountNumber;
		setAccountName(accountName);
		setBalance(balance);
	}

	/**
	 * 
	 * @return accountNumber the unique number associated with the account
	 */
	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 
	 * @return accountName the name associated with the account
	 */
	public String getAccountName() {
		return this.accountName;
	}

	/**
	 * 
	 * @param accountName the new name to associate with the account
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * 
	 * @return balance the current balance of the account
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance the new balance of the account
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @param amount the amount to withdraw (by which to decrease the balance)
	 * @throws InvalidAccountException if the intended withdrawal amount exceeds the account balance
	 * @see InvalidAccountException
	 */
	public void withdraw(double amount) throws InvalidAccountException {
		if (this.getBalance() - amount < 0) {
			throw new InvalidAccountException("Insufficient funds to withdraw " + amount);
		}
		this.setBalance(this.getBalance() - amount);
	}

	/**
	 * 
	 * @param amount the amount to deposit (by which to increase the balance)
	 * @throws InvalidAccountException if the intended deposit amount is negative
	 * @see InvalidAccountException
	 */
	public void deposit(double amount) throws InvalidAccountException {
		if (amount < 0) {
			throw new InvalidAccountException("Cannot deposit negative amount " + amount);
		}
		this.setBalance(this.getBalance() + amount);
	}
}