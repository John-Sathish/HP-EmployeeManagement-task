package com.example.restservice;

public class EmployeeManager {
	static Employees employees = new Employees();
	
	static {
		employees.get_employee().add(new Employee("1", "John","Sathish","johnsathish2004@gmail.com", "Software Engineer"));
		employees.get_employee().add(new Employee("2", "James","O'donell","james123@gmail.com", "Accountant"));
		employees.get_employee().add(new Employee("3", "Tom","Packwood","tom345@gmail.com", "Teacher"));

	}
	
	public Employees getAllEmployees() {
		return employees;
	}
	public void addEmployee(Employee em) {
		employees.get_employee().add(em);
		
	}

}
