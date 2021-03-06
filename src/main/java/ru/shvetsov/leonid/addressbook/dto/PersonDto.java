package ru.shvetsov.leonid.addressbook.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.Address;
import ru.shvetsov.leonid.addressbook.model.Contact;
import ru.shvetsov.leonid.addressbook.model.ContactGroup;
import ru.shvetsov.leonid.addressbook.model.Job;

import java.util.List;

@Data
public class PersonDto {

    private String name;
    private String surname;
    private String patronymic;
    private String nick;

    private Job job;
    private List<Address> addresses;
    private List<Contact> contacts;
    private List<ContactGroup> myGroups;

}
