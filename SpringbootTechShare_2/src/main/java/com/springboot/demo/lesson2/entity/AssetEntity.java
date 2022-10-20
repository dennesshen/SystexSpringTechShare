package com.springboot.demo.lesson2.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ASSET")
@IdClass(AssetPrimaryKey.class)
public class AssetEntity {
	
	@Id
	private Long fundmanager_id;
	
	@Id
	private String stock_symbol;
	
	@Column(columnDefinition = "numeric(19, 0) default 0")
	private BigDecimal total_cost;
	
	@Column(columnDefinition = "numeric(19, 0) default 0")
	private BigDecimal total_value;
	
	@Column(name = "CREATETIME", updatable = false,
			columnDefinition = "timestamp default now()")
	private LocalDateTime createTime;
	
	
	@Column(name = "LASTUPDATETIME", 
			columnDefinition = "timestamp default now()")
	private LocalDateTime lastUpdateTime;
	

}
