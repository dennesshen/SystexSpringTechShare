package com.springboot.demo.lesson2.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.springboot.demo.util.DataSendModel.DtoPresentField;
import com.springboot.demo.util.DataSendModel.DtoPresentNextLevelData;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "INVESTBANK")
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class InvestBankEntity { // invest_bank
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@DtoPresentField(group = "manager")
	private Long id;
	
	@Column(name = "bank_name")
	@JsonProperty(value = "company_name")
	@DtoPresentField(group = {"manager", "employee"})
	private String name;
	
	
	
	@OneToMany(mappedBy = "investBankEntity", 
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	//@JsonManagedReference
	@DtoPresentNextLevelData(group = {"manager", "employee"})
	private List<FundManagerEntity> fundManagerEntities;
}
