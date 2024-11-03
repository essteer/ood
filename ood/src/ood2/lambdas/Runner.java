package ood2.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
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

		Function<BankAccount,String> getNameAndBalance = ac -> ac.getAccountHolder() + ": " + ac.getBalance();
		System.out.println(getNameAndBalance.apply(account3));
		System.out.println(getNameAndBalance.apply(account4));
		
		Function<BankAccount,Double> getInterestDueOnAccount = ac -> ac.getBalance() * ac.getInterestRate() / 100;
		System.out.println(getInterestDueOnAccount.apply(account2));
		
		Function<BankAccount,Double> getInterestDueOnAccountOverdrawn = ac -> ac.getBalance() < 0 ? 0 : ac.getBalance() * ac.getInterestRate() / 100;
		System.out.println(getInterestDueOnAccountOverdrawn.apply(account2));
		System.out.println(getInterestDueOnAccountOverdrawn.apply(account8));
		
		Predicate<BankAccount> isCurrentAccount = ac -> ac.getAccountType().equals("current/checking");
		System.out.println(isCurrentAccount.test(account1));
		System.out.println(isCurrentAccount.test(account6));
		
		Predicate<BankAccount> isAccountOverdrawn = ac -> ac.getBalance() < 0;
		System.out.println(isAccountOverdrawn.test(account5));
		System.out.println(isAccountOverdrawn.test(account7));
		
		BiFunction<BankAccount,BankAccount,BankAccount> highestBalance = (ac1, ac2) -> ac1.getBalance() > ac2.getBalance() ? ac1 : ac2;
		System.out.println((highestBalance.apply(account3, account4)).getAccountHolder());
		
		Consumer<BankAccount> deductFeeOf10 = ac -> ac.setBalance(ac.getBalance() - 10);
		System.out.println("account2 balance: " + account2.getBalance());
		deductFeeOf10.accept(account2);
		System.out.println("account2 updated balance: " + account2.getBalance());
		System.out.println("account6 balance: " + account6.getBalance());
		deductFeeOf10.accept(account6);
		System.out.println("account6 updated balance: " + account6.getBalance());
		
		BiConsumer<BankAccount,Integer> deductAmount = (ac, amount) -> ac.setBalance(ac.getBalance() - amount);
		System.out.println("account1 balance: " + account1.getBalance());
		deductAmount.accept(account1, 100);
		System.out.println("account1 updated balance: " + account1.getBalance());
		System.out.println("account5 balance: " + account5.getBalance());
		deductAmount.accept(account5, 50);
		System.out.println("account5 updated balance: " + account5.getBalance());
		
		
		List<BankAccount> acArrayList = new ArrayList<>();
		acArrayList.add(account1);
		acArrayList.add(account2);
		acArrayList.add(account3);
		acArrayList.add(account4);
		acArrayList.add(account5);
		acArrayList.add(account6);
		acArrayList.add(account7);
		acArrayList.add(account8);
//		lambdasForListMethods(acArrayList);
//		lambdasForComparators(acArrayList);
		lambdasForMapMerge(acArrayList);
		
		
		
	}
	
	public static void lambdasForListMethods(List<BankAccount> acArrayList) {
		
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " Balance: " + ac.getBalance()));
		System.out.println();
		acArrayList.forEach(ac -> ac.setBalance(ac.getBalance() - 10));
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " Balance: " + ac.getBalance()));
		System.out.println();
		acArrayList.removeIf(ac -> ac.getBalance() < -500);
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " Balance: " + ac.getBalance()));
		System.out.println();
		acArrayList.removeIf(ac -> ac.getAccountType().equals("savings"));
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " Balance: " + ac.getBalance()));
	}
	
	public static void lambdasForComparators(List<BankAccount> acArrayList) {
		
		Comparator<BankAccount> sortByBalance = (ac1, ac2) -> Double.valueOf(ac1.getBalance()).compareTo(Double.valueOf(ac2.getBalance()));
		acArrayList.sort(sortByBalance);
		System.out.println("Sort by account balance:");
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " Balance: " + ac.getBalance()));
		System.out.println();
		
		Comparator<BankAccount> sortByAccountType = (ac1, ac2) -> ac1.getAccountType().compareTo(ac2.getAccountType());
		acArrayList.sort(sortByAccountType);
		System.out.println("Sort by account type:");
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " A/C type: " + ac.getAccountType()));
		System.out.println();
		
		Comparator<BankAccount> sortByAccountNumber = (ac1, ac2) -> Integer.valueOf(ac1.getAccountNumber()).compareTo(Integer.valueOf(ac2.getAccountNumber()));
		acArrayList.sort(sortByAccountNumber);
		System.out.println("Sort by account number:");
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " A/C type: " + ac.getAccountType()));
		System.out.println();
		
		Comparator<BankAccount> sortByTypeThenNumber = sortByAccountType.thenComparing(sortByAccountNumber);
		acArrayList.sort(sortByTypeThenNumber);
		System.out.println("Sort by account type then by number:");
		acArrayList.forEach(ac -> System.out.println("A/C number: " + ac.getAccountNumber() + " A/C holder: " + ac.getAccountHolder() + " A/C type: " + ac.getAccountType()));
		System.out.println();
		
	}
	
	public static void lambdasForMapMerge(List<BankAccount> acArrayList) {
		Map<Integer,Integer> bankCodeToAccountsMap = new HashMap<>();
		
		BiFunction<Integer,Integer,Integer> countPerBankCode = (currentValue, amountToAdd) -> currentValue + amountToAdd;
		for (BankAccount ac : acArrayList) {
			bankCodeToAccountsMap.merge(ac.getBankCode(), 1, countPerBankCode);
		}
		System.out.println("\nMap of bank codes to accounts");
		System.out.println(bankCodeToAccountsMap.toString());
		
		
        Map<Integer,Double> bankCodeToBalancesMap = new HashMap<>();
		
		BiFunction<Double,Double,Double> totalPerBankCode = (currentValue, amountToAdd) -> Math.round((currentValue + amountToAdd) * 100) / 100.0;
		for (BankAccount ac : acArrayList) {
			System.out.println(bankCodeToBalancesMap.toString());
			bankCodeToBalancesMap.merge(ac.getBankCode(), ac.getBalance(), totalPerBankCode);
		}
		System.out.println("\nMap of bank codes to total balances");
		System.out.println(bankCodeToBalancesMap.toString());
		
		
	}

}
