package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootTechShare2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTechShare2Application.class, args);
	}

}
