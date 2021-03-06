package ru.shvetsov.leonid.addressbook.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Job extends BaseEntity {

    @OneToOne(mappedBy = "job")
    private Person person;

    private String company;
    private String department;
    private String position;

}
