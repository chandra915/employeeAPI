package com.cogni.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.employee.entity.Employee;
import com.cogni.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/test")
	public String test() {
		return "Sucess";
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/employee")
	public List<Employee> listEmployee() {
		return employeeService.listEmployee();
	}

	@GetMapping("/employee/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long employeeID) {
		return employeeService.fetchEmployeeById(employeeID);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long employeeID) {
		return employeeService.deleteEmployee(employeeID);
	}

	@PutMapping("/employee/{id}")
	public Employee editEmployee(@PathVariable("id") Long employeeID, @RequestBody Employee employee) {
		return employeeService.editEmployee(employeeID, employee);
	}

}
