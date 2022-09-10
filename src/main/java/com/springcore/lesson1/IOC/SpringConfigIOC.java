package com.springcore.lesson1.IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigIOC {
	
	@Bean
	public Hello hello() {
		return new Hello();
	}
	
	@Bean(name = "hello4")
	public Hello hello2() {
		return new Hello();
	}
}
