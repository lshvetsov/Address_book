package ru.shvetsov.leonid.addressbook.api.v1.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Управление адресной книгой")
@RestController
@AllArgsConstructor
@RequestMapping(PersonController.BASE_URL)
public class PersonController {

    public static final String BASE_URL = "/api/v1/person";
    PersonService personService;

    @PostMapping(consumes = "application/json")
    @ApiOperation(value = "Создание записей в адресной книге")
    PersonDto createPerson (@Valid @RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping
    @ApiOperation(value = "Получение всех записей")
    List<PersonDto> getAllPerson () {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Получение записи по идентификатору")
    PersonDto getPersonById (@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Удаление записи")
    void deletePerson (@PathVariable String id) {
        personService.deletePerson(id);
    }

    @GetMapping(value = "/find")
    @ApiOperation(value = "Поиск записи по имени и фамилии")
    List<PersonDto> findPersonByNameAndSurname (@RequestParam String name, @RequestParam String surname) {
        return personService.findPersonByNameAndSurname(name, surname);
    }

    @GetMapping(value = "/findByContact")
    @ApiOperation(value = "Поиск записи по контакту")
    List<PersonDto> findPersonByNameAndSurname (@RequestParam String contact) {
        return personService.findPersonbyContact(contact);
    }

}
