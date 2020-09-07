package com.example.demo.examples.relations.onetoone.repository;

import com.example.demo.examples.relations.onetoone.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
