package com.empmanagement.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.crudapp.entity.Employee;
import com.empmanagement.crudapp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
 
	@Autowired
	private EmployeeRepository eRepo;
	
	@GetMapping("/")
	public String home() {
		return "Hello Everythoing works fine!";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> temp =  eRepo.findAll();
		System.out.println(temp);
		return temp;
	}

}
