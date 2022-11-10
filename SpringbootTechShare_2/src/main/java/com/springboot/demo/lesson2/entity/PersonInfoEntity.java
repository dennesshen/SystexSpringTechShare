package com.springboot.demo.lesson2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.demo.util.DataSendModel.DtoPresentField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSONINFO")
@JsonIgnoreProperties({"fundManagerEntity"})
public class PersonInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "IDNUMBER")
	@DtoPresentField
	private String idNumber;
	
	@Column
	private Integer age;
	
	@Column
	private String address;
	
	@Column(insertable = false, updatable = false)
	private Long fundmanager_id;
	
	@OneToOne
	@JoinColumn(name = "fundmanager_id")
	private FundManagerEntity fundManagerEntity;
	
	

}
