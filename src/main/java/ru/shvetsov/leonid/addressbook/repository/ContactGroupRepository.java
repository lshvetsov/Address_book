package ru.shvetsov.leonid.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shvetsov.leonid.addressbook.model.ContactGroup;

import java.util.UUID;

public interface ContactGroupRepository extends CrudRepository<ContactGroup, UUID> {
}
