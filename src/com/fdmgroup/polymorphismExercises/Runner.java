package com.fdmgroup.polymorphismExercises;

public class Runner {

	public static void main(String[] args) {
		
		UserAccountManager userAccountManager = new UserAccountManager();
		
		AdminUser.setMinAdminPasswordLength(10);
		
		AdminUser admin1 = new AdminUser("alexs", "1234", "Alex Smith");
		AdminUser admin2 = new AdminUser("bobj", "1234", "Bob Jones");
        Customer customer1 = new Customer("claireb", "1234", "Claire Bundy");		
        Customer customer2 = new Customer("davew", "1234", "Dave Walls");		
        
        admin1.changePassword("0987", "0987");
        System.out.println(admin1.getPassword());
        
        customer2.changePassword("6745", "4312");
        System.out.println(customer2.getPassword());
        
        admin2.accessWebsite();
        customer1.accessWebsite();
        
        userAccountManager.addUser(admin1);
        userAccountManager.addUser(admin2);
        userAccountManager.addUser(customer1);
        userAccountManager.addUser(customer2);
        
        boolean admin1Login = userAccountManager.login("bobj", "1234");
        boolean customer2Login = userAccountManager.login("petej", "cheese");
        
        System.out.println(admin1Login);
        System.out.println(customer2Login);
        
        System.out.println(AdminUser.getMinAdminPasswordLength());
        
        System.out.println("admin1 password: " + admin1.getPassword());
        admin1.changePassword("password", "password");
        System.out.println(admin1.getPassword());
        admin1.changePassword("longpassword", "longpassword");
        System.out.println(admin1.getPassword());
        
        System.out.println();
        System.out.println("customer2 password: " + customer2.getPassword());
        admin2.changePassword("newPassForYou", "newPassForYou", customer2);
        System.out.println("customer2 password: " + customer2.getPassword());
        
        System.out.println("Setting min customer password length");
        Customer.setMinCustomerPasswordLength(7);
        System.out.println("customer1 password: " + customer1.getPassword());
        customer1.changePassword("short", "short");
        System.out.println("customer1 password: " + customer1.getPassword());
        customer1.changePassword("notShort", "notShort");
        System.out.println("customer1 password: " + customer1.getPassword());
	}

}
