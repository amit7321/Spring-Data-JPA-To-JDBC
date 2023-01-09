package com.example.springdatajpademo;


import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/test")
                .username("postgres")
                .password("12345")
                .build();
    }

//    @Bean
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create()
//                .url("jdbc:postgresql://localhost:5432/test")
//                .username("SA")
//                .password("12345")
//                .build();
//    }
//
//    @Bean("pgsqlJDBC")
//    JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//
//    @Bean("msqlJDBC")
//    @Primary
//    JdbcTemplate jdbcTemplate2() {
//        return new JdbcTemplate(dataSource2());
//    }


}
