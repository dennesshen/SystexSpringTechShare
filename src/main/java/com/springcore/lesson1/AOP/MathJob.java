package com.springcore.lesson1.AOP;

import org.springframework.stereotype.Component;

@Component
public class MathJob {
	
	public void plus(Integer x, Integer y) {
		Integer sum = x + y;
		System.err.println("sum = " + sum);
	}
	
	public void multiply(Integer x, Integer y, Integer z) {
		Integer product = x*y*z;
		System.err.println("product = " + product);
	}
	
	public Integer divide(Integer x, Integer y) {
		Integer quotient = x / y;
		System.err.println("qutient = " + quotient);
		return quotient;
	}
	
}
