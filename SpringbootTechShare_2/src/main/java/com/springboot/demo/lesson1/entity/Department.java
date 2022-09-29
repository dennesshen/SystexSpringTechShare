package com.springboot.demo.lesson1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	private Long id;
	
	@Column
	private String departmenName;
	
}
