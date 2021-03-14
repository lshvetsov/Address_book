package ru.shvetsov.leonid.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shvetsov.leonid.addressbook.model.Contact;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, String> {
    List<Contact> findContactsByContactField(String contactField);
}
