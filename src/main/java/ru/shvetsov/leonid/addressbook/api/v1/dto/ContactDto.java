package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.BaseEntity;
import ru.shvetsov.leonid.addressbook.model.Person;
import ru.shvetsov.leonid.addressbook.utils.enums.ContactType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ContactDto extends BaseEntity {

    private String Id;
    private Person person;
    private ContactType type;
    private String provider;
    private String contactField;

}
