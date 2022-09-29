package com.springboot.demo.lesson1.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.lesson1.entity.Employee;
import com.springboot.demo.lesson1.service.EmployeeService;

@RestController
@RequestMapping("/restController")
public class HelloRestController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/test")
	public String test() {
		return "Hello RestController";
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee")
	public Map<String, Object> employee(@RequestParam(name = "name") String name,
						 @RequestParam(name = "position", required = false) String position,
						 @RequestParam(name = "salary", required = false, defaultValue = "36000")
						 Integer salary) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("name", name);
		map.put("position", position);
		map.put("salary", salary);
		return map;
	}
	
	
	
	
	

}
