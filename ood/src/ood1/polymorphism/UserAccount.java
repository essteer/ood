package ood1.polymorphism;

public abstract class UserAccount {
	
	private String username;
	private String password;
	private String fullName;
	
	public UserAccount(String username, String password, String fullName) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
    public boolean changePassword(String newPass, String confirmPass) {
	    if (newPass.equals(confirmPass) ) {
	    	this.password = newPass;
	    	return true;
	    }
	    return false;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public abstract void accessWebsite();

}
