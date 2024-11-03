package ood2.javadoc;

/**
 * @author Elliott Steer
 * Custom exception for handling invalid parameters passed to {@link BankAccount}
 * @see BankAccount
 * 
 */
public class InvalidAccountException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default exception with no custom message
	 */
	public InvalidAccountException() {
	}
	
	/**
	 * Overloaded exception with a custom message
	 * @param message indicates the reason the exception was thrown
	 */
	public InvalidAccountException(String message) {
		super(message);
	}

}
