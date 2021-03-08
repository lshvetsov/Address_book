package ru.shvetsov.leonid.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shvetsov.leonid.addressbook.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, String> {
}
