package com.springboot.demo.lesson2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
}
