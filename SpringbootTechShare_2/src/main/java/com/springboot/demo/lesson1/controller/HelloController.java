package com.springboot.demo.lesson1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.demo.lesson1.entity.Employee;

@Controller
@RequestMapping("/helloController")
public class HelloController {
	
	@Autowired
	private Employee mary;
	
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
	
	

}
