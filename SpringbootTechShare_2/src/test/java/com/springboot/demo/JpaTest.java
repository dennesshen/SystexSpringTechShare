package com.springboot.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.demo.lesson2.repository.FundManagerRepository;
import com.springboot.demo.lesson2.repository.InvestBankRepository;

@SpringBootTest
@Transactional
class JpaTest {
	
	@Autowired
	private InvestBankRepository bankRepository;

	@Autowired
	private FundManagerRepository managerRepository;
	
	@Test
	void contextLoads() {
		bankRepository.findAll().forEach(System.out::println);
		managerRepository.findAll().forEach(System.out::println);

	}

}
