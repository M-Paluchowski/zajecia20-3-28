package com.example.demo;

import com.example.demo.examples.relations.onetoone.model.Address;
import com.example.demo.examples.relations.onetoone.model.Person;
import com.example.demo.examples.relations.onetoone.repository.AddressRepository;
import com.example.demo.examples.relations.onetoone.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        //ONE-TO-ONE
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        AddressRepository addressRepository = context.getBean(AddressRepository.class);

        Address address = new Address();
        address.setCity("Wrocław");
        address.setFlatNumber("5");
        address.setHouseNumber("5");
        address.setStreet("Bałtycka");

        Person person = new Person();
        person.setFirstName("Jan");
        person.setLastName("Nowak");
        person.setAddress(address);

        addressRepository.save(address);
        personRepository.save(person);

        personRepository.findAll();
    }
}
