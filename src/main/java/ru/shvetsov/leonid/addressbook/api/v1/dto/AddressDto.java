package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.utils.enums.AddressType;

@Data
public class AddressDto {

    private AddressType type;
    private String country;
    private String region;
    private String city;
    private String postCode;
    private String street;
    private String houseNumber;

}
