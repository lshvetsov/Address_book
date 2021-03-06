package ru.shvetsov.leonid.addressbook.model;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.enums.AddressType;

import javax.persistence.*;

@Entity
@Data
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    private String country;
    private String city;
    private String postCode;
    private String street;
    private String houseNumber;

}
