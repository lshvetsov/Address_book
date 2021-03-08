package ru.shvetsov.leonid.addressbook.utils.mappers;

import org.mapstruct.Mapper;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.model.Person;

@Mapper
public interface PersonMapper {

    PersonDto personToPersonDto (Person person);
    Person personDtoToPerson (PersonDto personDto);

}
