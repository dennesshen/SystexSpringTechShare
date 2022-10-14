package com.springboot.demo.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.lesson2.entity.FundManagerEntity;

@Repository
public interface FundManagerRepository 
	extends JpaRepository<FundManagerEntity, Long> {
	
}
