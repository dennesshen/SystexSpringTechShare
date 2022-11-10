package com.springboot.demo.lesson2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.lesson2.dto.PersonInfoRecieveData;
import com.springboot.demo.lesson2.entity.FundManagerEntity;
import com.springboot.demo.lesson2.entity.PersonInfoEntity;
import com.springboot.demo.lesson2.entity.StockEntity;
import com.springboot.demo.lesson2.repository.FundManagerRepository;
import com.springboot.demo.lesson2.repository.StockRepository;
import com.springboot.demo.util.EntityBuilder;

@Service
public class FundmanagerService {
	
	@Autowired
	private FundManagerRepository managerRepository;
	
	@Autowired
	private StockRepository stockRepository;

	public PersonInfoEntity updateInfo(PersonInfoRecieveData recieveData) {
		
		EntityBuilder<PersonInfoEntity> 
		infoBuilder = new EntityBuilder<>();
		
		Long managerId = recieveData.getMaindata().getId();
		
		FundManagerEntity manager = 
				managerRepository.findById(managerId).get();
		
		if (manager.getPersonInfoEntity() != null) {
			infoBuilder.init(manager.getPersonInfoEntity());
		}else {
			infoBuilder.init(new PersonInfoEntity());
		}
		
		infoBuilder.convertAllDtoToEntity(recieveData.getDetaildata().get(0))
				   .injectFieldToEntity("fundManagerEntity", manager);
		
		manager.setPersonInfoEntity(infoBuilder.build());
		
		managerRepository.saveAndFlush(manager);
		
		return manager.getPersonInfoEntity();
		
	}

	public List<StockEntity> addStock(Long id, String symbol) {
		
		FundManagerEntity manager = 
				managerRepository.findById(id).get();
		
		StockEntity stockEntity = 
				stockRepository.findById(symbol)
							   .orElse(new StockEntity(symbol));
		try {
			manager.getStockEntities().add(stockEntity);
		} catch (Exception e) {
			List<StockEntity> stockEntities = new ArrayList<>();
			stockEntities.add(stockEntity);
			manager.setStockEntities(stockEntities);
		}
		
		managerRepository.saveAndFlush(manager);
		return manager.getStockEntities();
	}

	@Transactional
	public boolean demoTransactional() {
		
		FundManagerEntity manager = 
				managerRepository.findById(1l).get();
		
		manager.getPersonInfoEntity().setIdNumber("T987654321");
		managerRepository.saveAndFlush(manager);
		
		if (manager.getId() == 1l) {
			throw new RuntimeException("Transaction Demo Error");
		}
		
		addStock(1l, "2330.TW");
		
		return true;
	}
	
	
}
