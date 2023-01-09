package com.example.springdatajpademo;

import jakarta.persistence.*;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceProvider;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Person> findAll() {
        return
                jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }

    public Person findById(int id) {
        return
                jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] {id},
                        new BeanPropertyRowMapper<Person> (Person.class));
    }
}

// jdbc:h2:mem:d50537d3-f303-41f0-b164-dd6893a27151;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
// jdbcTemplate.update("insert into PERSON (id, name, location) values (10671, 'name', 'location')")