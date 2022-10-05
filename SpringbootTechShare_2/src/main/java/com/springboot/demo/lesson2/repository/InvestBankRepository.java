package com.springboot.demo.lesson2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.lesson2.entity.InvestBankEntity;

@Repository
public interface InvestBankRepository 
	extends JpaRepository<InvestBankEntity, Long> {
	
	List<InvestBankEntity> findByName(String name);

}
