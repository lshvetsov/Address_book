package ru.shvetsov.leonid.addressbook.service;

import ru.shvetsov.leonid.addressbook.api.v1.dto.ContactDto;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto createPerson (PersonDto personDto);
    PersonDto getPersonById (String Id);
    List<PersonDto> getAllPersons ();
    void deletePerson (String id);

    List<PersonDto> findPersonbyNameAndSurname(String name, String surname);
    List<PersonDto> findPersonbyContact (String contactField);

    PersonDto addContact (ContactDto contactDto, String personId);

}
