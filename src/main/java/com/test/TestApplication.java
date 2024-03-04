package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.model.Foo;
import com.test.service.FooService;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	protected static final Logger logger = LoggerFactory.getLogger(TestApplication.class);
	
	@Autowired
	protected FooService fooService;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
