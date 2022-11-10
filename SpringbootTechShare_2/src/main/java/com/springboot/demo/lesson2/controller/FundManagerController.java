package com.springboot.demo.lesson2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.lesson2.dto.PersonInfoRecieveData;
import com.springboot.demo.lesson2.entity.PersonInfoEntity;
import com.springboot.demo.lesson2.entity.StockEntity;
import com.springboot.demo.lesson2.service.FundmanagerService;
import com.springboot.demo.util.ParmeterException;
import com.springboot.demo.util.validationUtil.IdNumberValdator;

@RestController
@RequestMapping("/fundmanager")
public class FundManagerController {

	@Autowired
	private FundmanagerService managerService;
	
	@Autowired 
	private IdNumberValdator idNumberValdator;
	
	@PutMapping("/updatePersonInfo")
	public PersonInfoEntity 
	updatePersonInfo(@Valid@RequestBody PersonInfoRecieveData recieveData,
					 BindingResult bindingResult) {
		
		idNumberValdator.validate(recieveData, bindingResult);
		
		if (bindingResult.hasErrors()) {
			String field = bindingResult.getFieldError().getField();
			String message = bindingResult.getFieldError().getDefaultMessage();
			throw new ParmeterException(field + " : " + message);
		}
		
		return managerService.updateInfo(recieveData);
	}
	
	@PutMapping("/addStock")
	public List<StockEntity> 
	addStock(@RequestParam(name="managerid") Long id,
			 @RequestParam(name="symbol") String symbol) {
		
		return managerService.addStock(id, symbol);	
	}
	
	
	@PutMapping("/transactional_demo")
	public boolean demoTransaction() {

		return managerService.demoTransactional();
	}
	
}
