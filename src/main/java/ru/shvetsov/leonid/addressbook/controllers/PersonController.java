package ru.shvetsov.leonid.addressbook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shvetsov.leonid.addressbook.model.Person;
import ru.shvetsov.leonid.addressbook.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    PersonRepository personRepository;

    @PostMapping(value = "/person", consumes = "application/json")
    Person createPerson (@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @GetMapping("/person")
    List<Person> getAllPerson () {
        List<Person> result = new ArrayList<>();
        for (Person person : personRepository.findAll()) result.add(person);
        return result;
    }

}
