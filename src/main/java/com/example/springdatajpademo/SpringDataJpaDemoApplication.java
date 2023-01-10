package com.example.springdatajpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All user -> {}", dao.findAll());
		logger.info("All user 10671 -> {}", dao.findById(10671));
		logger.info("Delete user 1001 -> {}", dao.deleteById(1001));
	}
}
