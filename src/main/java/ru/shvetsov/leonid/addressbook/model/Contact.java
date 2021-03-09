package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shvetsov.leonid.addressbook.utils.enums.ContactType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    private ContactType type;
    private String provider;
    private String contactField;

}
