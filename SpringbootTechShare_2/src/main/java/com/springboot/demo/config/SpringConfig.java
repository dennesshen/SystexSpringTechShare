package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.demo.lesson1.entity.Employee;

@Configuration
public class SpringConfig {
	
	@Bean("mary")
	public Employee getMary() {
		return new Employee("Mary", "engineer", 50000);
	}
}
