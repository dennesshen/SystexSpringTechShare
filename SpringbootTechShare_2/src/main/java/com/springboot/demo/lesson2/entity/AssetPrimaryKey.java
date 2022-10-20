package com.springboot.demo.lesson2.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class AssetPrimaryKey implements Serializable{
	
	private Long fundmanager_id;
	
	private String stock_symbol;
	
}
