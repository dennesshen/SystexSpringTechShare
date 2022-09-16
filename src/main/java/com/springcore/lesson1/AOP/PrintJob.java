package com.springcore.lesson1.AOP;

import org.springframework.stereotype.Component;

@Component
public class printJob {
	
	public void print(String x) {
		System.out.println(x);
	}
	
	
	
}
