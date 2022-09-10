package com.springcore;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.lesson1.DI.Book;
import com.springcore.lesson1.DI.BookStore;
import com.springcore.lesson1.DI.SpringConfigDI;

public class DItest {

	@Test
	public void testDI() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("XMLForIOC.xml");
//		Book book1 = applicationContext.getBean("book1", Book.class);
//		System.out.println(book1);
//		
//		BookStoreXML bookStoreXML = applicationContext.getBean(BookStoreXML.class);
//		bookStoreXML.getBook();
		
		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SpringConfigDI.class);
//		Book book3 = applicationContext2.getBean("book3", Book.class);
//		System.out.println(book3);
		
		BookStore bookStoreJava = applicationContext2.getBean("bookStoreJava", BookStore.class);
		bookStoreJava.getBook();
		

	}
}
