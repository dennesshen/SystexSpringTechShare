package com.springcore;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.lesson1.AOP.AOPConfiguration;
import com.springcore.lesson1.AOP.MathJob;
import com.springcore.lesson1.AOP.PrintJob;

public class AOPtest {

	@Test
	public void testIOC() {
		
//		MathJob mathJob = new MathJob();
//		mathJob.plus(1, 2);
//		mathJob.multiply(2, 3, 4);
//		mathJob.divide(10, 3);

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		MathJob mathJob2 = applicationContext.getBean(MathJob.class); 
		PrintJob printJob = applicationContext.getBean(PrintJob.class);
		mathJob2.plus(1, 2);
		mathJob2.multiply(2, 3, 4);
		mathJob2.divide(10, 0);
		printJob.print("Hello");
		
	}
}
