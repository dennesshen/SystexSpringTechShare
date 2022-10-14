package com.springboot.demo.lesson2.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.lesson2.dto.DtoOfBank;
import com.springboot.demo.lesson2.entity.InvestBankEntity;
import com.springboot.demo.lesson2.repository.InvestBankRepository;
import com.springboot.demo.lesson2.service.BankAndManagerService;

@RestController
@RequestMapping("/investbank")
public class InvestBankController {
	
	@Autowired
	private InvestBankRepository bankRepository;
	
	@Autowired
	private BankAndManagerService service;

	
	@GetMapping("/get")
	public List<InvestBankEntity> getAllBank() {
		return bankRepository.findAll().stream()
									   .sorted(Comparator.comparing(InvestBankEntity::getId))
									   .collect(Collectors.toList());
	}
	
	@PostMapping("/get")
	public InvestBankEntity loadById(@RequestBody DtoOfBank receiveData) {
		return bankRepository.findById(receiveData.getId()).get();
	}
	
	@PostMapping("/getByName")
	public List<InvestBankEntity> loadByName(@RequestBody DtoOfBank receiveData) {
		return bankRepository.findByName(receiveData.getName());
	}
	
	@PutMapping("/insert")
	public boolean insert(@RequestBody DtoOfBank receiveData) {
		
		service.insert(receiveData);
		
		return true;
	}
	
	@PutMapping("/update")
	public boolean update(@RequestBody DtoOfBank receiveData) {
		
		service.update(receiveData);
		return true;
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@RequestBody DtoOfBank receiveData) {
		
		bankRepository.deleteById(receiveData.getId());
		return true;
	}
	
	
	
	
}
