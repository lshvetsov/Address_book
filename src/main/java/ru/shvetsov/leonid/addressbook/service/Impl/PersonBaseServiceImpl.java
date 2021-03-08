package ru.shvetsov.leonid.addressbook.service.Impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.shvetsov.leonid.addressbook.api.v1.dto.ContactDto;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.model.Contact;
import ru.shvetsov.leonid.addressbook.model.Person;
import ru.shvetsov.leonid.addressbook.repository.ContactGroupRepository;
import ru.shvetsov.leonid.addressbook.repository.ContactRepository;
import ru.shvetsov.leonid.addressbook.repository.PersonRepository;
import ru.shvetsov.leonid.addressbook.service.PersonService;
import ru.shvetsov.leonid.addressbook.utils.mappers.ContactMapper;
import ru.shvetsov.leonid.addressbook.utils.mappers.PersonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PersonBaseServiceImpl implements PersonService {

    PersonRepository personRepository;
    ContactRepository contactRepository;
    PersonMapper personMapper;
    ContactMapper contactMapper;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person resultPerson = personRepository.save(personMapper.personDtoToPerson(personDto));
        return personMapper.personToPersonDto(resultPerson);
    }

    @Override
    public PersonDto getPersonById(String id) {
        Person resultPerson = personRepository.findById(id).orElseThrow();
        return personMapper.personToPersonDto(resultPerson);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> result = new ArrayList<>();
        personRepository.findAll().iterator().forEachRemaining(result::add);
        return result.stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonDto> findPersonbyNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname).stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> findPersonbyContact(String contactField) {
        return personRepository.findByContactField(contactField).stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto addContact(ContactDto contactDto, String personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Contact contact = contactMapper.contactDtoToContact(contactDto);
        contact.setPerson(person);
        contactRepository.save(contact);
        return personRepository.findById(personId).stream()
                .map(personMapper::personToPersonDto)
                .findFirst()
                .orElseThrow();
    }
}
