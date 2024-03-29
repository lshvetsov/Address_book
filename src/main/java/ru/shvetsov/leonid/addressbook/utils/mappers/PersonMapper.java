package ru.shvetsov.leonid.addressbook.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shvetsov.leonid.addressbook.api.v1.dto.JobDto;
import ru.shvetsov.leonid.addressbook.api.v1.dto.PersonDto;
import ru.shvetsov.leonid.addressbook.model.Job;
import ru.shvetsov.leonid.addressbook.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto personToPersonDto (Person person);
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Person personDtoToPerson (PersonDto personDto);

}
