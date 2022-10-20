package com.springboot.demo.lesson2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.lesson2.dto.PersonInfoRecieveData;
import com.springboot.demo.lesson2.entity.PersonInfoEntity;
import com.springboot.demo.lesson2.entity.StockEntity;
import com.springboot.demo.lesson2.service.FundmanagerService;

@RestController
@RequestMapping("/fundmanager")
public class FundManagerController {

	@Autowired
	private FundmanagerService managerService;
	
	@PutMapping("/updatePersonInfo")
	public PersonInfoEntity 
	updatePersonInfo(@RequestBody PersonInfoRecieveData recieveData) {
		
		return managerService.updateInfo(recieveData);
	}
	
	@PutMapping("/addStock")
	public List<StockEntity> 
	addStock(@RequestParam(name="managerid") Long id,
			 @RequestParam(name="symbol") String symbol) {
		
		return managerService.addStock(id, symbol);	
	}
	
}
