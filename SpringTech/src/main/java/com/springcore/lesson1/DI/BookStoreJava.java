package com.springcore.lesson1.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "bookStoreJava")
public class BookStoreJava implements BookStore{
	
	@Autowired
	@Qualifier(value = "book3")
	Book book;

	@Override
	public void getBook() {
		System.out.println(book);
	}
}
