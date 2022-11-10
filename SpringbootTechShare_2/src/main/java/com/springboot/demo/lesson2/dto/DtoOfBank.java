package com.springboot.demo.lesson2.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.springboot.demo.util.validationUtil.CreateValid;
import com.springboot.demo.util.validationUtil.SqlInjectValid;
import com.springboot.demo.util.validationUtil.UpdateValid;

import lombok.Data;

@Data
public class DtoOfBank {
	
	@Null(groups = {CreateValid.class})
	@NotNull(groups = UpdateValid.class)
	private Long id;
	
	//@NotNull
	//@NotEmpty
	@NotBlank(groups = {CreateValid.class, UpdateValid.class})
	@SqlInjectValid(groups = CreateValid.class)
	private String name;
	
	@Email(groups = {CreateValid.class})
	@NotBlank(groups = {CreateValid.class})
	@Length(groups = CreateValid.class, max = 100, min = 5)
	private String email;
	
	@Valid
	private List<DtoOfManager> manager;
}
