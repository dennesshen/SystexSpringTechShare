package com.springcore;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.lesson1.IOC.Hello;
import com.springcore.lesson1.IOC.SpringConfigIOC;

public class IOCtest {

	@Test
	public void testIOC() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("XMLForIOC.xml");
//		Hello hello1 = applicationContext.getBean("hello1", Hello.class);
//		System.out.println(hello1);
//		
//		Hello hello2 = applicationContext.getBean("hello2", Hello.class);
//		System.out.println(hello2);
//		
//		Hello hello3 = applicationContext.getBean("hello1", Hello.class);
//		System.out.println(hello3);
		
		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SpringConfigIOC.class);
		Hello hello4 = applicationContext2.getBean("hello", Hello.class);
		System.out.println(hello4);
		
		Hello hello5 = applicationContext2.getBean("hello4", Hello.class);
		System.out.println(hello5);
		
		
		
	}
}
