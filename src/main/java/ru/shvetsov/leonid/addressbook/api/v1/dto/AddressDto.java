package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.BaseEntity;
import ru.shvetsov.leonid.addressbook.model.Person;
import ru.shvetsov.leonid.addressbook.utils.enums.AddressType;

import javax.persistence.*;

@Data
public class AddressDto extends BaseEntity {

    private String id;
    private AddressType type;
    private String country;
    private String city;
    private String postCode;
    private String street;
    private String houseNumber;

}
