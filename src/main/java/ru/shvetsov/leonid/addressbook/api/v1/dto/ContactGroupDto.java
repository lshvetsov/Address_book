package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.BaseEntity;
import ru.shvetsov.leonid.addressbook.model.Person;

import javax.persistence.*;
import java.util.Set;

@Data
public class ContactGroupDto extends BaseEntity {

    private String id;
    private String name;
    private Person person;
    private Set<Person> participants;
}
