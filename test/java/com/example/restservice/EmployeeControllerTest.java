package com.example.restservice;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    EmployeeManager employeeManager;
    @MockBean
	Employees employeeList;

    
   
	@Test
	public void getEmployees_success() throws Exception{
		
    
		Mockito.when(employeeManager.getAllEmployees()).thenReturn(employeeManager.employees);

		mockMvc.perform(MockMvcRequestBuilders
	            .get("/employees")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(jsonPath("$._employee", Matchers.hasSize(3)))
	            .andExpect(jsonPath("$._employee.[2].first_name", is("Tom")));
		
		
		
	}
	
	@Test
	public void addEmployee_success() throws Exception{
		
		final Employee test_employee = new Employee("4", "Test","Employee","test@gmail.com", "TEST");

		when(employeeList.get_employee().add(test_employee)).thenReturn(null);
			mockMvc.perform(post("/employees")
	    	    .contentType(MediaType.APPLICATION_JSON)
	    	    .content(mapper.writeValueAsString(test_employee))
	    	    .characterEncoding("utf-8"))
	    	    .andExpect(MockMvcResultMatchers.status().isOk())
	    	    .andExpect(jsonPath("$", Matchers.notNullValue()))
	    	    .andExpect(jsonPath("$.first_name", is("Test")));
		
		

		
		
	}

	
}
