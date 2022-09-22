package com.springboot.demo.lesson1.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.demo.lesson1.entity.Employee;
import com.springboot.demo.lesson1.service.EmployeeService;

@Controller
@RequestMapping("/helloController")
public class HelloController {
	
	@Autowired
	private Employee mary;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hellController() {
		
		return "Hello Spring MVC without template";
	}
	
	@GetMapping(value = "/hello2")
	public String hellController2() {
		
		return "Hello";
	}
	
	@GetMapping(value = "/model_and_attribute")
	public String getHelloWeb(Model model) {
		model.addAttribute("hello", "Model And Attribute");
		
		return "Hello";
	}
	
	@GetMapping(value = "/getMary")
	public String getMary(Model model) {
		model.addAttribute("hello", "Model And Attribute");
		model.addAttribute("Mary", mary);
		
		return "Hello";
	}
	
	@GetMapping(value = "/getEmployees")
	public String getEmployees(Model model) {
		model.addAttribute("hello", "Model And Attribute");
		model.addAttribute("Employees", employeeService.getAllEmployee());
		
		return "Hello";
	}
	
	@GetMapping(value = "/getEmployee/{name}")
	public String getEmployee(@PathVariable("name") String name ,Model model) {
		model.addAttribute("hello", "Model And Attribute");
		model.addAttribute("Employees", employeeService.getAllEmployee());
		model.addAttribute("employee", employeeService.getEmployee(name));
		return "Hello";
	}
	
	@GetMapping(value = "/getEmployee")
	public String getEmployeeByParm(@PathParam("name") String name ,Model model) {
		model.addAttribute("hello", "Model And Attribute");
		model.addAttribute("Employees", employeeService.getAllEmployee());
		model.addAttribute("employee", employeeService.getEmployee(name));
		return "Hello";
	}
	
	
	
	

}
