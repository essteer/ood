package com.ood1.mod8;

public class Employee {
	
	private String name;
	private String jobTitle;
	private double hourlyWage;
	private static double minimumWage;
	
	public Employee() {
		
	}
	
	public Employee(String name, String jobTitle, double hourlyWage) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.hourlyWage = hourlyWage;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	public void setHourlyWage(double hourlyWage) {
		if (hourlyWage < minimumWage) {
			this.hourlyWage = minimumWage;
		} else {
			this.hourlyWage = hourlyWage;
		}
	}
	
	public static double getMinimumWage() {
		return minimumWage;
	}
	
	public static void setMinimumWage(double newMinimumWage) {
		minimumWage = newMinimumWage;
	}
}
