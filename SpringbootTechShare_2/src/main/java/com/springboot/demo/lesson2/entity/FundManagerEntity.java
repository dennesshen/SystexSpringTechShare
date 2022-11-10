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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.springboot.demo.util.DataSendModel.DtoPresentField;
import com.springboot.demo.util.DataSendModel.DtoPresentNextLevelData;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "FUNDMANAGER")
@ToString(exclude = "investBankEntity")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class FundManagerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@DtoPresentField
	private Long id;
	
	@Column(name = "manager_name")
	@DtoPresentField
	private String name;
	
	@Column
	@DtoPresentField
	private Long balance;
	
	@Column(insertable = false, updatable = false)
	@JsonIgnore
	private Long investbank_id;
	
	@ManyToOne
	@JoinColumn(name = "investbank_id")
	//@JsonBackReference
	private InvestBankEntity investBankEntity;
	
	@JsonIgnore
	@OneToOne(mappedBy = "fundManagerEntity", cascade = CascadeType.ALL)
	@DtoPresentNextLevelData(name = "personinfo")
	private PersonInfoEntity personInfoEntity;
	
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,
						   CascadeType.REFRESH,
						   CascadeType.MERGE})
	@JoinTable(
		name = "Asset",
		joinColumns = @JoinColumn(name = "fundmanager_id"),
		inverseJoinColumns = @JoinColumn(name = "stock_symbol")
	)
	@DtoPresentNextLevelData(name = "stocks")
	private List<StockEntity> stockEntities;
	
	
}
