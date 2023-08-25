package com.example.restservice;

import java.util.ArrayList;
import java.util.List;


public class Employees {
	private static ArrayList<Employee> list = new ArrayList<>();
	
	
	public List<Employee> get_employee(){
		
		
		return list;
	}
	
	public void set_employee(Employee employee) {
		list.add(employee);
	}
	
	

}
