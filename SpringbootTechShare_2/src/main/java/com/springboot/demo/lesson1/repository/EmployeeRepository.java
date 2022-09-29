package com.springboot.demo.lesson1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.demo.lesson1.entity.Employee;

import lombok.Getter;

@Repository
@Getter
public class EmployeeRepository {
	private final List<Employee> employees = new ArrayList<>();
	
	public EmployeeRepository() {
		employees.add(new Employee("Mary", "engineer", 50000));
		employees.add(new Employee("Bob", "sell", 44000));
		employees.add(new Employee("May", "engineer", 54000));
	}

	public List<Employee> insert(List<Employee> data) {
		employees.addAll(data);
		return employees;
	}
}
