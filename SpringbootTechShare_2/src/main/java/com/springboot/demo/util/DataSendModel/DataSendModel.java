package com.springboot.demo.util.DataSendModel;

import java.util.LinkedHashMap;

/*
* @author  Christine Hsieh 
*/

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSendModel {
	
	private Map<String, Object> maindata;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, List<DataSendModelSecond>> detaildata;
	
	public DataSendModel(Map<String, Object> maindata) {
		this.maindata = maindata;
	}
	
	public DataSendModel(Map<String, Object> maindata, List<DataSendModelSecond> singleDetailData) {
		this.maindata = maindata;
		Map<String, List<DataSendModelSecond>> detaildata = new LinkedHashMap<>();
		detaildata.put("detaildata", singleDetailData);
		this.detaildata = detaildata;
	}
	
	
	@JsonAnyGetter
	public Map<String, List<DataSendModelSecond>> getDetaildata() {
		return detaildata;
	}

	@JsonAnySetter
	public void setDetaildata(Map<String, List<DataSendModelSecond>> detaildata) {
		this.detaildata = detaildata;
	}

}
