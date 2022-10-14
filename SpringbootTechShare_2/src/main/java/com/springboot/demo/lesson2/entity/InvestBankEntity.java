package com.springboot.demo.lesson2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "INVESTBANK")
@ToString(exclude = {"fundManagerEntities"})
public class InvestBankEntity { // invest_bank
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "bank_name")
	private String name;
	
	
	@OneToMany(mappedBy = "investBankEntity", 
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	private List<FundManagerEntity> fundManagerEntities;
}
