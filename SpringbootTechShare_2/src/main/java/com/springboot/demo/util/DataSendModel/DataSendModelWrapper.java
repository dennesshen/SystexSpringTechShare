package com.springboot.demo.util.DataSendModel;
/*
* @author  Christine Hsieh 
*/
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.springboot.demo.util.MyReflectionUtil;




public class DataSendModelWrapper {
	
	//group 用來指定 分組 ，以便於把同一個entity根據需求包裝成不同的回傳資料
	public static <T> DataSendModel wrapper(T entity, String group)  {
		
		DataSendModel model = wrapperFirstLevel(entity, group);
		
		return model;
	}
	public static <T> DataSendModel wrapper(T entity)  {	
		
		DataSendModel model = wrapper(entity, "");
		
		return model;
	}

	
	private static <T> DataSendModel wrapperFirstLevel(T entity, String group) {
		Map<String, Object> mainData ; 
		Map<String, List<DataSendModelSecond>> detaildata;
		DataSendModel dataSendModel =  new DataSendModel();
		
		
		try {
			mainData = getMainFieldValues(entity, group);
			dataSendModel.setMaindata(mainData);
			detaildata = getNextLevelValues(entity, group);
			dataSendModel.setDetaildata(detaildata);
		}catch (NoSuchFieldException e) {
			//System.out.println(entity.toString());
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		return dataSendModel;
	}
	

	private static <T> DataSendModelSecond wrapperSecondLevel(T entity, String group) {
		Map<String, Object> mainData ; 
		Map<String, List<DataSendModelSecond>> detaildata;
		DataSendModelSecond dataSendModel =  new DataSendModelSecond();
		
		try {
			mainData = getMainFieldValues(entity, group);
			dataSendModel.setMaindata(mainData);
			detaildata = getNextLevelValues(entity, group);
			dataSendModel.setDetaildata(detaildata);
		}catch (NoSuchFieldException e) {
			//System.out.println(entity.toString());
		}catch (Exception e) {
			e.printStackTrace();
		} 

		
		return dataSendModel;
		
	}
	
	
	private static <T> Map<String, Object> getMainFieldValues(T entity, String group) throws IllegalArgumentException, IllegalAccessException {
		
		 Map<String, Object> mainData = new LinkedHashMap<>();
		 
		for(Field field : MyReflectionUtil.getAllFields(entity.getClass())) {
			
			if(field.isAnnotationPresent(DtoPresentField.class)) {
				
				//判斷是否是指定group所需要包裝的field
				DtoPresentField annotation = field.getAnnotation(DtoPresentField.class);
				boolean isGroup = Arrays.stream(annotation.group()).anyMatch(g -> g.equals(group));
				if(!isGroup && !group.equals("")) continue;
				
				String fieldName = field.getName().toLowerCase();
				field.setAccessible(true);
				Object objectValue = field.get(entity);
				
				mainData.put(fieldName, objectValue);
				
			}
		}
		
		return mainData;
	}
	
	private static <T>  Map<String, List<DataSendModelSecond>> 
	getNextLevelValues(T entity, String group) throws  NoSuchFieldException {
		
		Map<String, List<DataSendModelSecond>> detailDatas = new LinkedHashMap<>();

		int count = 0;// 用來計預設的名稱是第幾個detaildata
		for(Field field : MyReflectionUtil.getAllFields(entity.getClass()) ) {
			if(field.isAnnotationPresent(DtoPresentNextLevelData.class)) {

				//判斷是否是指定group所需要包裝的field
				DtoPresentNextLevelData annotation = field.getAnnotation(DtoPresentNextLevelData.class);
				boolean isGroup = Arrays.stream(annotation.group()).anyMatch(g -> g.equals(group));
				if(!isGroup && !group.equals("")) continue;
				
				
				//決定fieldName 要不要用預設的detailData，還是要用本身的fieldName
				String fieldName = "detaildata" + (count==0? "": count);
				if(!annotation.name().equals("")) {
					fieldName = annotation.name();
				}else {
					count++;
				}
				
				
				field.setAccessible(true);
				Object  nextLevelObject = new Object();
				List<Object>  nextLevelEntities = new ArrayList<>();
				
				try {
					nextLevelObject = field.get(entity);
					
					if (nextLevelObject instanceof List ) {
						nextLevelEntities = (List<Object>) nextLevelObject;
					}else if(nextLevelObject != null) {
						nextLevelEntities.add(nextLevelObject);
					}
					
					if (nextLevelEntities.isEmpty()) continue;

				} catch (Exception e) {
					continue;
				}
				
				//準備一個空的list 負責接下層處理完帶上來的DataSendModel
				List<DataSendModelSecond> nextLevelData = new ArrayList<>();
				
				for (Object nextLevelEntity : nextLevelEntities) {
					nextLevelData.add( wrapperSecondLevel(nextLevelEntity, group));
				}
				
				detailDatas.put(fieldName, nextLevelData);
			}
		}
		if (detailDatas.isEmpty()) throw new NoSuchFieldException();
		return detailDatas;
	}
	
	
	
	
	//1.0私有方法：用來找到被標注DtoPresentNextLevelData或DtoPresentField的的屬性對應的getter方法 
	//2.0後來找到更好的getField的方法，故棄用這個方法，但先保留以免後面遇到問題要回來重用這個方法
	@Deprecated
	private static <T> List<Method> compareMethodWithFieldName(T entity, String whichKindMethod) {
		
		switch (whichKindMethod) {
			case "field":
				
				List<String> dtoNames =  
				Arrays.stream(entity.getClass().getDeclaredFields()).filter(f -> f.isAnnotationPresent(DtoPresentField.class))
																	.map(f -> "get" + f.getName().toLowerCase())
																	.collect(Collectors.toList());
				
				List<Method> dtoPresentFieldMethods =
				Arrays.stream(entity.getClass().getMethods()).filter(m -> dtoNames.contains( m.getName().toLowerCase()))
															 .collect(Collectors.toList());
				
				return dtoPresentFieldMethods;
	
			case "nextLevel":
				
				List<String> dtoNexLevelData =  
				Arrays.stream(entity.getClass().getDeclaredFields()).filter(f -> f.isAnnotationPresent(DtoPresentNextLevelData.class))
																	.map(f -> "get" + f.getName().toLowerCase())
																	.collect(Collectors.toList());
				
				List<Method> dtoPresentNextLevelMethods =
				Arrays.stream(entity.getClass().getMethods()).filter(m -> dtoNexLevelData.contains( m.getName().toLowerCase()))
															 .collect(Collectors.toList());
				
				return dtoPresentNextLevelMethods;
			}
		
		return null;
	}

}
