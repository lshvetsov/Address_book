package ru.shvetsov.leonid.addressbook.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shvetsov.leonid.addressbook.api.v1.dto.ContactDto;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.exception.BusinessError;
import ru.shvetsov.leonid.addressbook.exception.BusinessErrorInfo;
import ru.shvetsov.leonid.addressbook.model.Address;
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
@AllArgsConstructor
public class PersonBaseServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    ContactMapper contactMapper;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);

        if (checkDouble(person)) throw new BusinessError(BusinessErrorInfo.PERSON_ALREADY_CREATE);

        person.getAddresses().forEach(x -> x.setPerson(person));
        person.getContacts().forEach(x -> x.setPerson(person));

        return personMapper.personToPersonDto(personRepository.save(person));
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
    public List<PersonDto> findPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname).stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> findPersonbyContact(String contactField) {
        List<Contact> contacts = contactRepository.findContactsByContactField(contactField);
        return contacts.stream()
                .map(x -> personRepository.findByContactsContains(x))
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
                .findFirst().orElseThrow();
    }

    private boolean checkDouble (Person person) {
        List<Person> currentPerson = personRepository.findByNameAndSurname(person.getName(), person.getSurname());
        return !currentPerson.isEmpty();
    }

}
