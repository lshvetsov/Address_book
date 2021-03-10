package ru.shvetsov.leonid.addressbook.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shvetsov.leonid.addressbook.api.v1.dto.ContactDto;
import ru.shvetsov.leonid.addressbook.model.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    ContactDto contactToContactDto (Contact contact);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Contact contactDtoToContact (ContactDto contactDto);

}
