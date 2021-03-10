package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.utils.enums.ContactType;

@Data
public class ContactDto {

    private ContactType type;
    private String provider;
    private String contactField;

}
