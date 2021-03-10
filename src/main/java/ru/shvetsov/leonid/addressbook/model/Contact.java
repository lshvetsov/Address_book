package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ru.shvetsov.leonid.addressbook.utils.enums.ContactType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    private ContactType type;
    private String provider;
    private String contactField;

}
