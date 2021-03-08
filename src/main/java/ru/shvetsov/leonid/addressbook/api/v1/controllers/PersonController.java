package ru.shvetsov.leonid.addressbook.api.v1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.service.PersonService;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    PersonService personService;

    @PostMapping(value = "/person", consumes = "application/json")
    PersonDto createPerson (@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping("/person")
    List<PersonDto> getAllPerson () {
        return personService.getAllPersons();
    }

}
