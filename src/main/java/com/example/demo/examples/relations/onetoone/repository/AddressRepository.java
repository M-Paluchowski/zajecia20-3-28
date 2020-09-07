package com.example.demo.examples.relations.onetoone.repository;

import com.example.demo.examples.relations.onetoone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
