package ru.shvetsov.leonid.addressbook.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shvetsov.leonid.addressbook.api.v1.dto.JobDto;
import ru.shvetsov.leonid.addressbook.model.Job;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDto jobToJobDto (Job job);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Job jobDtoToJob (JobDto jobDto);

}
