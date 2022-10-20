package com.springboot.demo.util.DataRecieveModel;
/*
* @author  Christine Hsieh 
*/

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class DataRecieveModel_1M1D<K, T> implements RecieveModel<K> {
	
	@Valid
	private K maindata;
	
	@Valid
	private List<T> detaildata;
	

	@Override
	@JsonIgnore
	public Object getMaindataId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
		
}
