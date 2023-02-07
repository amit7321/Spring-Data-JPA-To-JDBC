package com.example.springdatajpademo.jpa;

import com.example.springdatajpademo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager ;
    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
}
