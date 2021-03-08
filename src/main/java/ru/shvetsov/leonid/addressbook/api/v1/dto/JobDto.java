package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.BaseEntity;
import ru.shvetsov.leonid.addressbook.model.Person;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
public class JobDto extends BaseEntity {

    private String id;
    private Person person;
    private String company;
    private String department;
    private String position;

}
