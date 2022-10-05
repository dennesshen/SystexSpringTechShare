package com.springboot.demo.lesson2.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DtoOfBank {
	
	
	private Long id;
	
	@NotBlank
	private String name;
}
