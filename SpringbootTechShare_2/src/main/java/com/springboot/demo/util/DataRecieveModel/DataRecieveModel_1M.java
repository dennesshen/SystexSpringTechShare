package com.springboot.demo.util.DataRecieveModel;
/*
* @author  Christine Hsieh 
*/


import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class DataRecieveModel_1M<K> implements RecieveModel<K> {
	
	@Valid
	private K maindata;
	
	@Override
	@JsonIgnore
	public Long getMaindataId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
