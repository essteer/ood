package com.ood2.solid.worker;

public class SalariedWorker implements Worker {
	
	private int employeeId;
	private String employeeName;
	private double salary;
	
	public SalariedWorker(int id, String name, double salary) {
		this.employeeId = id;
		this.employeeName = name;
		this.salary = salary;
	}
	
	@Override
	public int getEmployeeId() {
		return this.employeeId;
	}
	
	@Override
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(String newName) {
		this.employeeName = newName;
	}
	
	@Override
	public double getSalary() {
		return this.salary;
	}
	
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}

}
