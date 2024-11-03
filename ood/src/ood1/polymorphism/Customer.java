package ood1.polymorphism;

public class Customer extends UserAccount {
	
	private static int minCustomerPasswordLength;
	
	public Customer(String username, String password, String fullName) {
		super(username, password, fullName);
	}
	
	@Override
	public void accessWebsite() {
		System.out.println("Accessing website as customer");
	}
	
	@Override
	public boolean changePassword(String newPass, String confirmPass) {
		if (newPass.equals(confirmPass) &&
			newPass.length() >= getMinCustomerPasswordLength()) {
	    	super.changePassword(newPass, confirmPass);
	    	return true;
	    }
	    return false;
	}
	
	public static int getMinCustomerPasswordLength() {
		return minCustomerPasswordLength;
	}
	
	public static void setMinCustomerPasswordLength(int length) {
		minCustomerPasswordLength = length;
	}

}
