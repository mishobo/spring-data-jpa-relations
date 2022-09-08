package com.husseinabdallah287.springdatajparelationships.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husseinabdallah287.springdatajparelationships.models.Employee;
import com.husseinabdallah287.springdatajparelationships.repository.EmployeeRepository;
import com.husseinabdallah287.springdatajparelationships.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/addEmployee")
	public Employee createOrder(@Valid @RequestBody Employee employee ) {
		return employeeRepository.save(employee);
	}
	
    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    
    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return reportService.exportReport(format);
    }

}
