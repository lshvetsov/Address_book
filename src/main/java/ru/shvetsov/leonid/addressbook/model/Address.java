package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shvetsov.leonid.addressbook.utils.enums.AddressType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    private String country;
    private String region;
    private String city;
    private String postCode;
    private String street;
    private String houseNumber;

}
