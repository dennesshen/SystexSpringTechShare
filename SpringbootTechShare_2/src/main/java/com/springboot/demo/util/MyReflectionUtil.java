package com.springboot.demo.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class MyReflectionUtil {
	
	private static final Class[] annotations = new Class[]{OneToMany.class, 
														   OneToOne.class, 
														   ManyToMany.class, 
														   ManyToOne.class};
	
	public static Field checkAllfield(Class<?> clazz, String name) {
		//System.out.println("name = " + name);
		name = name.substring(0,1).toLowerCase() + name.substring(1, name.length());
		Field field = null;	
		try {
			field = clazz.getDeclaredField(name);
		} catch (Exception e) {
			if (clazz.getSuperclass() != null ) {
			   field = checkAllfield(clazz.getSuperclass(), name);
			}
		}
		
		return field;
	}
	
	
	
	public static List<Field> getAllFields(Class<?> objectClass){
		List<Field> resultList = new ArrayList<>();
		List<Field> declaredFields = Arrays.asList(objectClass.getDeclaredFields());
		resultList.addAll(declaredFields);
		
		if (objectClass.getSuperclass() != Object.class) {
			resultList.addAll(getAllFields(objectClass.getSuperclass()));
		}
		return resultList;
	}
	
	
	
	public static boolean checkLinkedAnnotation(Field field) {
	
		for(Class annotationClass : annotations) {
			if(field.isAnnotationPresent(annotationClass)) return true;
		}
			
		return false;
	}
	
	
	
	
	public static Map<String, Object> getFieldAndValueByMap(Object object){
		
		Map<String, Object> resultMap = new LinkedHashMap<>();
		List<Field> fields = getAllFields(object.getClass());
		
		for (Field field : fields) {
			
			field.setAccessible(true);
			
			try {
				Object value = field.get(object);
				resultMap.put(field.getName(), value);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		return resultMap;
	}
	
	
}
