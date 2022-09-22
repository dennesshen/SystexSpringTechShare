package com.springcore.lesson1.DI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfigDI {
	 
	@Bean(name = "book3")
	public Book getBook3() {
		
		Book book3 = new Book();
		book3.setName("C++");
		book3.setAuthor("Christine");
		
		return book3;
	}
}
