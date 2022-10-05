package com.springboot.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class JdbcTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("limitJdbc")
	private JdbcTemplate limitJdbcTemplate;
	
	@Test
	void contextLoads() {
		String sql = "Select * From INVESTBANK";
		List<Map<String, Object>> result1 = jdbcTemplate.queryForList(sql);
		result1.forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		List<Map<String, Object>> result2 = limitJdbcTemplate.queryForList(sql);
		result2.forEach(System.out::println);
	}

}
