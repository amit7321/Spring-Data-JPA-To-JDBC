package com.example.springdatajpademo;


import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class DbConfig {

    //@Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/test")
                .username("postgres")
                .password("12345")
                .build();
    }




}
