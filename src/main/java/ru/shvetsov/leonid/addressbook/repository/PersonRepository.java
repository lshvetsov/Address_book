package ru.shvetsov.leonid.addressbook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.shvetsov.leonid.addressbook.model.Contact;
import ru.shvetsov.leonid.addressbook.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByNameAndSurname(String name, String surname);
    Person findByContactsContains (Contact contact);
}
