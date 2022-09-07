package com.husseinabdallah287.springdatajparelationships.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husseinabdallah287.springdatajparelationships.models.Employee;
import com.husseinabdallah287.springdatajparelationships.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public Employee createOrder(@Valid @RequestBody Employee employee ) {
		return employeeRepository.save(employee);
	}

}
