package com.springboot.demo.lesson1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.lesson1.entity.Employee;
import com.springboot.demo.lesson1.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.getEmployees();
	}
	
	public Employee getEmployee(String name) {
		return employeeRepository.getEmployees()
								 .stream()
								 .filter(e -> e.getName().equals(name))
								 .findAny()
								 .get();
	}

}
