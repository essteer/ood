package com.ood2.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Runner {

	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount(12345678,987654,"Mr J Smith","savings",1.1,25362.91);
		BankAccount account2 = new BankAccount(87654321,234567,"Ms J Jones","current/checking",0.2,550);
		BankAccount account3 = new BankAccount(74639572,946284,"Dr T Williams","savings",1.1,4763.32);
		BankAccount account4 = new BankAccount(94715453,987654,"Ms S Taylor","savings",1.1,10598.01);
		BankAccount account5 = new BankAccount(16254385,234567,"Mr P Brown","current/checking",0.2,-195.74);
		BankAccount account6 = new BankAccount(38776543,946284,"Ms F Davies","current/checking",0.2,-503.47);
		BankAccount account7 = new BankAccount(87609802,987654,"Mr B Wilson","savings",1.1,2.5);
		BankAccount account8 = new BankAccount(56483769,234567,"Dr E Evans","current/checking",0.2,-947.72);
		
		List<BankAccount> acArrayList = new ArrayList<>();
		acArrayList.add(account1);
		acArrayList.add(account2);
		acArrayList.add(account3);
		acArrayList.add(account4);
		acArrayList.add(account5);
		acArrayList.add(account6);
		acArrayList.add(account7);
		acArrayList.add(account8);
		
		// The number of current/checking accounts in the ArrayList
		Predicate<BankAccount> isCurrentCheckingAccount = ac -> ac.getAccountType().equals("current/checking");
		long numCurrentAccounts = acArrayList.stream()
		    .filter(isCurrentCheckingAccount)
		    .count();
		System.out.println(String.format("There are %d current/checking accounts", numCurrentAccounts));
		
		// The number of accounts which are overdrawn
		Predicate<BankAccount> isOverdrawn = ac -> ac.getBalance() < 0;
		long numOverdrawnAccounts = acArrayList.stream()
				.filter(isOverdrawn)
				.count();
		System.out.println(String.format("There are %d overdrawn accounts", numOverdrawnAccounts));
		
		// The highest account balance
		Optional<Double> highestBalance = acArrayList.stream()
				.map(ac -> ac.getBalance())
				.max(Comparator.naturalOrder());
		
		highestBalance.ifPresent(balance ->
				System.out.println(String.format("Highest balance: " + highestBalance.get()))
		);
		
		// The average account balance
		OptionalDouble averageBalance = acArrayList.stream()
				.mapToDouble(ac -> ac.getBalance())
				.average();
		averageBalance.ifPresent(balance ->
		        System.out.println(String.format("Average balance: " + Math.round(averageBalance.getAsDouble() * 100.0)/100.0))
        );
		
		// The average balance of accounts which are in credit
		Predicate<BankAccount> inCredit = ac -> ac.getBalance() >= 0.0;
		OptionalDouble averageBalanceInCredit = acArrayList.stream()
				.filter(inCredit)
				.mapToDouble(ac -> ac.getBalance())
				.average();
		averageBalanceInCredit.ifPresent(balance ->
            System.out.println(String.format("Average balance (in credit): " + Math.round(averageBalanceInCredit.getAsDouble() * 100.0)/100.0))
        );
		
		// The sum of all overdrafts
		Predicate<BankAccount> overdrawn = ac -> ac.getBalance() < 0.0;
		OptionalDouble sumOfAllOverdrafts = acArrayList.stream()
				.filter(overdrawn)
				.mapToDouble(ac -> ac.getBalance())
				.reduce((a, b) -> a + b);
		sumOfAllOverdrafts.ifPresent(balance ->
            System.out.println(String.format("Sum of all overdrafts: " + Math.round(sumOfAllOverdrafts.getAsDouble() * 100.0)/100.0))
        );
		
		// The total amount interest due to be paid to accounts which are in credit
		OptionalDouble interestDueToInCreditAccounts = acArrayList.stream()
				.filter(inCredit)
				.mapToDouble(ac -> ac.getBalance() * (ac.getInterestRate()/100))
				.reduce((a, b) -> a + b);
		interestDueToInCreditAccounts.ifPresent(balance ->
        System.out.println(String.format("Total interest due to in credit accounts: " + Math.round(interestDueToInCreditAccounts.getAsDouble() * 100.0)/100.0))
    );

	}

}
