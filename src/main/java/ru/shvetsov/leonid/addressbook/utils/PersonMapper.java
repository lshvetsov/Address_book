package ru.shvetsov.leonid.addressbook.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import ru.shvetsov.leonid.addressbook.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.model.Person;

@Mapper
public interface PersonMapper {
    Person personDtoToEntity (PersonDto source);
    PersonDto personToDto (Person destination);
}
