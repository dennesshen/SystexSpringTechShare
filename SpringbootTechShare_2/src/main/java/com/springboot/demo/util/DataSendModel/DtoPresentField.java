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
public @interface DtoPresentField {
	
	//用來做分組包裝
	String[] group() default {""};	
}


