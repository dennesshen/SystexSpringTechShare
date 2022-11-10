package com.springboot.demo.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.demo.util.ParmeterException;

@ControllerAdvice(basePackages = {"com.springboot.demo.lesson2"})
public class GenericExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> 
	dealException(MethodArgumentNotValidException ex) {
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		FieldError fieldError = (FieldError) errors.get(0);
		String message = fieldError.getObjectName() + "."
				       + fieldError.getField() + " : "
				       + fieldError.getDefaultMessage();
		
		Map<String, String> data = new LinkedHashMap<>();
		data.put("data", null);
		data.put("status", "400");
		data.put("message", message);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
		
	}
	
	@ExceptionHandler(value = ParmeterException.class)
	public ResponseEntity<?> dealParameterException(ParmeterException ex) {
		
		
		Map<String, String> data = new LinkedHashMap<>();
		
		data.put("data", null);
		data.put("status", "400");
		data.put("message", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
	}
	
	

}
