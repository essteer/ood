package com.ood1.mod8;

public class Runner {

	public static void main(String[] args) {
		
		Employee.setMinimumWage(9.53);
//		System.out.println(Employee.getMinimumWage());
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		employee1.setHourlyWage(1.99);
		employee2.setHourlyWage(5.45);
		employee3.setHourlyWage(10.55);
		
		System.out.println(employee1.getHourlyWage());
		System.out.println(employee2.getHourlyWage());
		System.out.println(employee3.getHourlyWage());

	}

}
