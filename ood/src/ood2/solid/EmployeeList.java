package ood2.solid;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	
	private List<Employee> employeeList;
	
	public EmployeeList() {
		this.employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}
	
	public void removeEmployee(int employeeId) {
		for (int i=0; i<employeeList.size(); i++) {
			Employee employee = this.employeeList.get(i);
			if (employee.getEmployeeId() == employeeId) {
				this.employeeList.remove(i);
				break;
			}
		}
	}
	
	public void updateEmployee(Employee employee) {
		for (Employee currentEmployee : this.employeeList) {
			if (currentEmployee.getEmployeeId() == employee.getEmployeeId()) {
				currentEmployee.setEmployeeName(employee.getEmployeeName());
				currentEmployee.setSalary(employee.getSalary());
				break;
			}
		}
	}
	
	public List<Employee> listEmployees() {
		return this.employeeList;
	}

}
