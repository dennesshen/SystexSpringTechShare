package com.springboot.demo.lesson2.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STOCK")
@RequiredArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StockEntity {
	
	@Id
	@NonNull
	private String symbol;
	
	@Column
	private String companyName;
	
	@Column
	private BigDecimal nowPrice;
	
	
	@ManyToMany(mappedBy = "stockEntities")
	private List<FundManagerEntity> fundManagerEntities;
	
	
	@Column(name = "CREATETIME", updatable = false)
	@CreatedDate
	private LocalDateTime createTime;
	
	
	@Column(name = "LASTUPDATETIME")
	@LastModifiedDate
	private LocalDateTime lastUpdateTime;

}
