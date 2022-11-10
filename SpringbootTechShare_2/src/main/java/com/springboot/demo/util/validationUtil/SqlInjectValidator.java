package com.springboot.demo.util.validationUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SqlInjectValidator 
	implements ConstraintValidator<SqlInjectValid, String>{

	private SqlInjectValid sqlInjectValid;
	
	@Override
	public void initialize(SqlInjectValid constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		this.sqlInjectValid = constraintAnnotation;
		
	}
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		
		Set<String> forbidWords = new HashSet<>();
		forbidWords.add("'");
		forbidWords.add(",");
		
		String forbidWordString = forbidWords.stream().collect(Collectors.joining());
		
		// [^',]
		String regex = "[^"+ forbidWordString  +"]*";
		
		

		return value.matches(regex);
	}

}
