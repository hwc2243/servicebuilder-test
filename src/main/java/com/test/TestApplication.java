package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {

	protected static final Logger logger = LoggerFactory.getLogger(TestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
