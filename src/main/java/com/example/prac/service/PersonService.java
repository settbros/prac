package com.example.prac.service;

import com.example.prac.entity.Person;
import com.example.prac.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository pr;

    public Person addPerson(Person person){
        return pr.save(person);
    }

    public List<Person> getAll() {
        System.out.println("Getting data from db");
        return pr.findAll();
    }

    @Cacheable(cacheNames = "person", key="#id")
    public Optional<Person> getAPerson(int id) {
        System.out.println("Getting data from db");
        return pr.findById(id);
    }

    public List<Person> addMultiplePerson(List<Person> person) {
        return pr.saveAll(person);
    }

    @CacheEvict(cacheNames = "person", key="#id")
    public void deletePerson(int id) {
        pr.deleteById(id);
    }

    @CachePut(cacheNames = "person", key="#id")
    public void updatePerson(Person person, int id) {
        Optional<Person> person1 = pr.findById(id);
        if(person1.isPresent()){
            person1.get().setFirstName(person.getFirstName());
            person1.get().setLastName(person.getLastName());
            pr.save(person1.get());
        }
    }
}
