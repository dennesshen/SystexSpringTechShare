package com.springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.demo.lesson2.repository.InvestBankRepository;

@SpringBootTest
class JpaTest {
	
	@Autowired
	private InvestBankRepository bankRepository;

	
	@Test
	void contextLoads() {
		bankRepository.findAll().forEach(System.out::println);
	}

}
