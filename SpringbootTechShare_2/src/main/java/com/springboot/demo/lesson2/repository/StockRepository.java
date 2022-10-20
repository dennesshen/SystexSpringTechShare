package com.springboot.demo.lesson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.lesson2.entity.StockEntity;

@Repository
public interface StockRepository 
	extends JpaRepository<StockEntity, String> {
	

}
