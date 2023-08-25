package com.example.restservice;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class EmployeeController {
	
	
	Employees employeesList = new Employees();;
	EmployeeManager employeeManager = new EmployeeManager();
	@GetMapping(path = "/employees", produces = "application/json")
	public Employees getEmployees() {
		return employeeManager.getAllEmployees();
	}
	
	@PostMapping(path = "/employees",consumes = "application/json", produces = "application/json")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeesList.get_employee().add(employee);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployee_id())
                .toUri();

      return employee;
		
	}
	
	
	
	

}
