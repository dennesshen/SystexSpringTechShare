package com.springboot.demo.lesson1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private String name;
	
	private String position;
	
	private Integer salary;
	
	
}
