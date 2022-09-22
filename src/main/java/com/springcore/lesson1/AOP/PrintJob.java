package com.springcore.lesson1.AOP;

import org.springframework.stereotype.Component;

@Component
public class PrintJob {
	
	public void print(String x) {
		System.err.println(x);
	}
	
	
	
}
