package ru.shvetsov.leonid.addressbook.bootstrap;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.shvetsov.leonid.addressbook.model.*;
import ru.shvetsov.leonid.addressbook.repository.ContactRepository;
import ru.shvetsov.leonid.addressbook.repository.PersonRepository;
import ru.shvetsov.leonid.addressbook.utils.enums.AddressType;
import ru.shvetsov.leonid.addressbook.utils.enums.ContactType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Data
public class PersonBootstrap implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        loadPerson();
    }

    private void loadPerson () {
        /*Person person = new Person("Elon", "Mask", "", "", null,
                null, null, null);
        Job job = new Job(person, "Tesla", "Management", "CEO");
        Address address = new Address(person, AddressType.HOME, "USA", "Texas",
                "New city", "00000-1", "Main", "1");
        Contact contact = new Contact(person, ContactType.EMAIL, "Tesla.com",
                "elon.mask@tesla.com");
        List<Address> addresses = new ArrayList<>(Collections.singleton(address));
        List<Contact> contacts = new ArrayList<>(Collections.singleton(contact));
        person.setJob(job);
        person.setAddresses(addresses);
        person.setContacts(contacts);
        personRepository.save(person);*/
    }

}
