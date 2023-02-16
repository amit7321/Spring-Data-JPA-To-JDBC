package com.example.springdatajpademo;

import com.example.springdatajpademo.entity.Person;
import com.example.springdatajpademo.jpa.PersonJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.sql.DataSource;
import java.util.Date;

@SpringBootApplication
@EntityScan(basePackages = "com.example.springdatajpademo.entity")
public class SpringDataJpaDemoApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
/*	@Autowired
	PersonJdbcDao dao;*/

	@Autowired
	PersonJpaRepository repository ;

	@PersistenceContext
	EntityManager entityManager ;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//logger.info("All user -> {}", .findAll());
		logger.info("All user 10671 -> {}", repository.findById(10671));
		logger.info("Inserting user 1071 -> {}", repository.insert(new Person(1071,"Tara", "Dhaka", new Date())));
		logger.info("Inserting user 1061 -> {}", repository.insert(new Person(1061,"Salam", "Chittagong", new Date())));
		logger.info("Update user 1071 -> {}", repository.update(new Person("Tara", "rangpur", new Date())));
		repository.deleteById(404);
		//logger.info("Delete user 1001 -> {}", dao.deleteById(1001));

		/*entityManager.getTransaction().begin();
		Person p = new Person("Rahim", "Dhaka", new Date());
		entityManager.persist(p);
		entityManager.getTransaction().commit();*/
	}
}
