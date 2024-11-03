package ood2.javadoc;

/**
 * @author Elliott Steer
 */
public class Main {

	/**
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		BankAccount myAccount = new BankAccount(1, "myAccount", 0);
		System.out.println(myAccount.getBalance());
		
		try {
			myAccount.deposit(800);
			myAccount.deposit(-900);
		} catch (InvalidAccountException e) {
			e.printStackTrace();
		}
		System.out.println(myAccount.getBalance());
		
		
		try {
    		myAccount.withdraw(1000);
		} catch (InvalidAccountException e) {
		    e.printStackTrace();
		}

	}

}
