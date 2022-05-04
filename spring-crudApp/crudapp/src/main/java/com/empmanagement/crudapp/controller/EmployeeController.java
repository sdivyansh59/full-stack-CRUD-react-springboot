package com.empmanagement.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
//		System.out.println(temp);
		return temp;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployeeDetails( @RequestBody Employee employee) {
		return eRepo.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable Long id) {
		return eRepo.findById(id).get();
	}
	
	@PutMapping("/employees")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteSingleEmployee(@PathVariable Long id) {
		 eRepo.deleteById(id); // it return void
		 return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	

}
