package ru.shvetsov.leonid.addressbook.api.v1.controllers.v1;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.service.PersonService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    public static final String BASE_URL = "/api/v1/person";
    PersonService personService;

    @PostMapping(consumes = "application/json")
    PersonDto createPerson (@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping("/")
    List<PersonDto> getAllPerson () {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    PersonDto getPersonById (@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(value = "/{id}")
    void deletePerson (@PathVariable String id) {
        personService.deletePerson(id);
    }

    @GetMapping(value = "/find")
    List<PersonDto> findPersonByNameAndSurname (@RequestParam String name, @RequestParam String surname) {
        return personService.findPersonbyNameAndSurname(name, surname);
    }

    @GetMapping(value = "/findByContact")
    List<PersonDto> findPersonByNameAndSurname (@RequestParam String contact) {
        return personService.findPersonbyContact(contact);
    }

}
