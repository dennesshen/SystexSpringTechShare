package com.springboot.demo.util;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EntityBuilder<T> {
	
	private T entity;
	
	private List<Field> entityFields;
	
	public EntityBuilder<T> init(T entity) {
		
		this.entity = entity;
		this.entityFields = MyReflectionUtil.getAllFields(entity.getClass());
		return this;
	}
	

	
	public <K> EntityBuilder<T> convertAllDtoToEntity(K dto) {

		Field[] fields =  MyReflectionUtil.getAllFields(dto.getClass()).toArray(new Field[0]);

		for(Field field : fields) {
			  String fieldName = field.getName();
			  try {
					field.setAccessible(true);
					Object fieldValue = field.get(dto);
					injectFieldToEntity(fieldName, fieldValue);
			  } catch (Exception e) {
			  }
		}
		return this;
	}
	
	public  EntityBuilder<T> convertMapToEntity(Map<String, Object> map) {

		for(Entry<String, Object> entry : map.entrySet()) {
			  try {
				  	String fieldName = entry.getKey();
					Object fieldValue = entry.getValue();
					injectFieldToEntity(fieldName, fieldValue);
			  } catch (Exception e) {
			  }
		}
		return this;
	}	
	
	public EntityBuilder<T> injectFieldToEntity(String fieldName, Object fieldValue) {
		if (fieldValue == null) return this;
		//System.out.println(fieldName+" : "+fieldValue);

		this.entityFields.stream()
						 .filter(f -> f.getName().toLowerCase().equals(fieldName.toLowerCase()))
						 .forEach(f -> {
											try {
											    f.setAccessible(true);
											    f.set(entity, fieldValue);
											} catch (IllegalArgumentException e) {
												//e.printStackTrace();
												
												if (f.getType().equals(Timestamp.class)) {
													try {
														LocalDateTime value = (LocalDateTime) fieldValue;
														f.set(entity, Timestamp.valueOf(value));
													} catch (Exception e1) {
													}
												}
												
												
											} catch (Exception e) {
											}
						  				}
								);
		return this;
			  
	}
	
	public T build() {

		return this.entity;
	}
	
	public void clear() {
		this.entity = null;
	}

}
