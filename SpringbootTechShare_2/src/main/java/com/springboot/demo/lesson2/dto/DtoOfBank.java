package com.springboot.demo.lesson2.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DtoOfBank {
	
	
	private Long id;
	
	@NotBlank
	private String name;
	
	private List<DtoOfManager> manager;
}
