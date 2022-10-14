package com.springboot.demo.lesson2.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.lesson2.dto.DtoOfBank;
import com.springboot.demo.lesson2.dto.DtoOfManager;
import com.springboot.demo.lesson2.entity.FundManagerEntity;
import com.springboot.demo.lesson2.entity.InvestBankEntity;
import com.springboot.demo.lesson2.repository.FundManagerRepository;
import com.springboot.demo.lesson2.repository.InvestBankRepository;
import com.springboot.demo.util.EntityBuilder;

@Service
public class BankAndManagerService {

	@Autowired
	private InvestBankRepository bankRepository;
	
	@Autowired
	private FundManagerRepository managerRepository;
	
	@Transactional
	public boolean insert(DtoOfBank receiveData) {
		
		EntityBuilder<InvestBankEntity> bankEntityBuilder = new EntityBuilder<>();
		EntityBuilder<FundManagerEntity> managerEntityBuilder = new EntityBuilder<>();
		
		InvestBankEntity newBankEntity =
		bankEntityBuilder.init(new InvestBankEntity())
						 .convertAllDtoToEntity(receiveData)
						 .build();
		
		List<FundManagerEntity> fundManagerEntities = new ArrayList<>();
		for (DtoOfManager manager : receiveData.getManager()) {
			managerEntityBuilder.init(new FundManagerEntity())
								.convertAllDtoToEntity(manager)
								.injectFieldToEntity("investBankEntity", newBankEntity);
			fundManagerEntities.add(managerEntityBuilder.build());
		}
		
		newBankEntity.setFundManagerEntities(fundManagerEntities);
		bankRepository.saveAndFlush(newBankEntity);
		
		
		
		return true;
	}

	@Transactional
	public boolean update(DtoOfBank receiveData) {
		
		EntityBuilder<InvestBankEntity> bankEntityBuilder = new EntityBuilder<>();
		EntityBuilder<FundManagerEntity> managerEntityBuilder = new EntityBuilder<>();
		
		InvestBankEntity originBank = 
			bankRepository.findById(receiveData.getId()).get();
		
		bankEntityBuilder.init(originBank)
					     .convertAllDtoToEntity(receiveData);
		
		List<FundManagerEntity> fundManagerEntities = new ArrayList<>();
		for (DtoOfManager manager : receiveData.getManager()) {
			managerEntityBuilder.init(new FundManagerEntity())
								.convertAllDtoToEntity(manager)
								.injectFieldToEntity("investBankEntity", originBank);
			fundManagerEntities.add(managerEntityBuilder.build());
		}
		
		originBank.getFundManagerEntities().clear();
		originBank.getFundManagerEntities().addAll(fundManagerEntities);
		bankRepository.saveAndFlush(originBank);

		return true;
	}

}
