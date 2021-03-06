package ru.shvetsov.leonid.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shvetsov.leonid.addressbook.model.Person;

import java.util.UUID;

public interface PersonRepository extends CrudRepository <Person, UUID> {
}
