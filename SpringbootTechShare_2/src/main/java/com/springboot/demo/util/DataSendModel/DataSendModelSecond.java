package com.springboot.demo.util.DataSendModel;

import java.util.LinkedHashMap;

/*
* @author  Christine Hsieh 
*/

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonSerialize(using = DtoSendModelSecondSerializer.class)
@NoArgsConstructor
public class DataSendModelSecond {
	
	
	private Map<String, Object> maindata;
	
	private Map<String, List<DataSendModelSecond>> detaildata;
	
	public DataSendModelSecond(Map<String, Object> maindata) {
		super();
		this.maindata = maindata;
	}
	
	public DataSendModelSecond(Map<String, Object> maindata, 
							   List<DataSendModelSecond> singleDetailData) {
		super();
		this.maindata = maindata;
		Map<String, List<DataSendModelSecond>> map = new LinkedHashMap<>();
		map.put("detaildata", singleDetailData);
		
		this.detaildata = map;
	}



	
	public Map<String, List<DataSendModelSecond>> getDetaildata() {
		return detaildata;
	}

	public void setDetaildata(Map<String, List<DataSendModelSecond>> detaildata) {
		this.detaildata = detaildata;
	}

	
	
}
