package com.example.prac.controller;

import com.example.prac.entity.Person;
import com.example.prac.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonService ps;

    @GetMapping("/{name}")
    public ResponseEntity<String> hi(@PathVariable("name") String name){
        return ResponseEntity.ok("Hi "+name);
    }

    @GetMapping("/getAll")
    public List<Person> getAllPerson(){
        return ps.getAll();
    }

    @GetMapping("/getPerson/{id}")
    public Optional<Person> getAPerson(@PathVariable("id") int id){
        return ps.getAPerson(id);
    }

    @PostMapping(value="/savePerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        System.out.println(person);
        Person persistedPerson = ps.addPerson(person);
       return ResponseEntity.created(URI.create(String.format("/person/%s", person.getFirstName())))
               .body(persistedPerson);
    }

    @PostMapping("/saveMultiplePerson")
    public void savePerson(@RequestBody List<Person> person){
        System.out.println(person);
        ps.addMultiplePerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable("id") int id){
        ps.deletePerson(id);
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@RequestBody Person person,@PathVariable("id") int id){
        ps.updatePerson(person,id);
    }


}
