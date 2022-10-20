package com.springboot.demo.lesson2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "FUNDMANAGER")
@ToString(exclude = "investBankEntity")
public class FundManagerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "manager_name")
	private String name;
	
	@Column
	private Long balance;
	
	@Column(insertable = false, updatable = false)
	@JsonIgnore
	private Long investbank_id;
	
	@ManyToOne
	@JoinColumn(name = "investbank_id")
	@JsonIgnore
	private InvestBankEntity investBankEntity;
	
	@OneToOne(mappedBy = "fundManagerEntity", cascade = CascadeType.ALL)
	private PersonInfoEntity personInfoEntity;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,
						   CascadeType.REFRESH,
						   CascadeType.MERGE})
	@JoinTable(
		name = "Asset",
		joinColumns = @JoinColumn(name = "fundmanager_id"),
		inverseJoinColumns = @JoinColumn(name = "stock_symbol")
	)
	private List<StockEntity> stockEntities;
	
	
}
