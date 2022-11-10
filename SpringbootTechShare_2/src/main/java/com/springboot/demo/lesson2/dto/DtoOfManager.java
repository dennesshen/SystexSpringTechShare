package com.springboot.demo.lesson2.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.springboot.demo.util.validationUtil.CreateValid;
import com.springboot.demo.util.validationUtil.UpdateValid;

import lombok.Data;

@Data
public class DtoOfManager {
	
	@Null(groups = {CreateValid.class})
	private Long id;
	
	@NotBlank(groups = {CreateValid.class, UpdateValid.class})
	private String name;
	
	@Digits(groups = CreateValid.class, integer = 2, fraction = 2)
	private Long balance;
	
	
		
}
