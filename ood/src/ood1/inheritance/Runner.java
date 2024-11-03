package ood1.inheritance;

public class Runner {

	public static void main(String[] args) {
		
		UserAccountManager userAccountManager = new UserAccountManager();
		
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
        
        
        
	}

}
