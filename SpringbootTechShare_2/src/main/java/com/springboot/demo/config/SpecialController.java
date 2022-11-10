package com.springboot.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.springboot.demo.lesson2.controller.FundManagerController;

@ControllerAdvice(basePackageClasses = FundManagerController.class)
public class SpecialController {
	
	

}
