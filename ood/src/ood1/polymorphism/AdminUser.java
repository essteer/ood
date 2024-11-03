package ood1.polymorphism;

public class AdminUser extends UserAccount {
	
	private static int minAdminPasswordLength;
	
	public AdminUser(String username, String password, String fullName) {
		super(username, password, fullName);
	}
	
	@Override
	public void accessWebsite() {
		System.out.println("Accessing website with admin rights");
	}
	
	@Override
	public boolean changePassword(String newPass, String confirmPass) {
		if (newPass.equals(confirmPass) &&
			newPass.length() >= getMinAdminPasswordLength()) {
	    	super.changePassword(newPass, confirmPass);
	    	return true;
	    }
	    return false;
	}
	
	public boolean changePassword(String newPass, String confirmPass, UserAccount user) {
		boolean isChanged = user.changePassword(newPass, confirmPass);
		return isChanged;
	}
	
	public static int getMinAdminPasswordLength() {
		return minAdminPasswordLength;
	}
	
	public static void setMinAdminPasswordLength(int length) {
		minAdminPasswordLength = length;
	}

}
