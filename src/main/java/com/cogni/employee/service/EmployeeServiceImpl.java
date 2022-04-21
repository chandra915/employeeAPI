package com.cogni.employee.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogni.employee.entity.Employee;
import com.cogni.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchEmployeeById(Long employeeID) {

		return employeeRepository.findById(employeeID).get();
	}

	@Override
	public String deleteEmployee(Long employeeID) {
		Employee e = employeeRepository.findById(employeeID).get();
		employeeRepository.delete(e);
		return "Employee Record Deleted";
	}

	@Override
	public Employee editEmployee(Long employeeID, Employee employee) {

		Employee e = employeeRepository.findById(employeeID).get();
		if (Objects.nonNull(employee.getEmployeeFirstName()) && !"".equals(employee.getEmployeeFirstName())) {
			e.setEmployeeFirstName(employee.getEmployeeFirstName());
		}
		if (Objects.nonNull(employee.getEmployeeLastName()) && !"".equals(employee.getEmployeeLastName())) {
			e.setEmployeeLastName(employee.getEmployeeLastName());
		}
		if (Objects.nonNull(employee.getEmployeeEmail()) && !"".equals(employee.getEmployeeEmail())) {
			e.setEmployeeEmail(employee.getEmployeeEmail());
		}
		if (Objects.nonNull(employee.getEmployeePhone()) && !"".equals(employee.getEmployeePhone())) {
			e.setEmployeePhone(employee.getEmployeePhone());
		}
		if (Objects.nonNull(employee.getEmployeLocation()) && !"".equals(employee.getEmployeLocation())) {
			e.setEmployeLocation(employee.getEmployeLocation());
		}

		return employeeRepository.save(e);
	}

}
