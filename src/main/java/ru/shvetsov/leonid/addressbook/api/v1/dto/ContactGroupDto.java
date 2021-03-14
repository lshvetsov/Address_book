package ru.shvetsov.leonid.addressbook.api.v1.dto;

import lombok.Data;
import ru.shvetsov.leonid.addressbook.model.Person;

import java.util.Set;

@Data
public class ContactGroupDto {

    private String name;
    private Set<PersonDto> participants;
}
