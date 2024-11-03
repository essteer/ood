package ood1.conditionals;

public class ComplexConditionals {

	public static void main(String[] args) {
		
//		int accountNumber = 50000000;
		int accountNumber = 50000;
		
		if (accountNumber >= 10000000 && accountNumber <= 99999999) {
			System.out.println("valid account number");
		} else {
			System.out.println("invalid account number");
		}
		
		String flightCode = "BA5678";
		
		if (flightCode.substring(0,2).equals("BA") ||
			flightCode.substring(0,2).equals("FR") ||
		    flightCode.substring(0,2).equals("LH")) {
			System.out.println("valid airline");
		} else {
			System.out.println("unrecognised or invalid airline");
		}
		
        String flightCode2 = "MX5678";
		
		if (!(flightCode2.substring(0,2).equals("BA") ||
			flightCode2.substring(0,2).equals("FR") ||
		    flightCode2.substring(0,2).equals("LH"))) {
			System.out.println("unrecognised or invalid airline");
		}
		
		boolean validPassport = true;
		boolean validDrivingLicence = false;
		
		if (validPassport || validDrivingLicence) {
			System.out.println("id verified");
		} else {
			System.out.println("unable to verify id");
		}
		
		boolean hasLicence = true;
		boolean isDead = true;
		boolean hasPassedEyeTest = true;
		
		if (hasLicence && !(isDead) && hasPassedEyeTest) {
			System.out.println("can still drive");
		} else {
			System.out.println("not licenced to drive");
		}

	}

}
