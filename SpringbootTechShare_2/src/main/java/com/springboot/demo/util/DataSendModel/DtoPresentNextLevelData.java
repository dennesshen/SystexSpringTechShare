package com.springboot.demo.util.DataSendModel;

/*
* @author  Christine Hsieh 
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoPresentNextLevelData {
	//用來做分組包裝
	String[] group() default {""};	
	
	//用來做是否要另外取名
	String name() default "" ;
}


