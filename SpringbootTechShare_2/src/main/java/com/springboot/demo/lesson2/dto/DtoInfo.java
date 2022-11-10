package com.springboot.demo.lesson2.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DtoInfo {
	
	
	private String idNumber;
	
	private Integer age;
	
	@NotBlank
	private String address;
}
