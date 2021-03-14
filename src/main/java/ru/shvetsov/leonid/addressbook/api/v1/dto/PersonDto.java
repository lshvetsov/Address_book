package ru.shvetsov.leonid.addressbook.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ApiModel(value = "Person", description = "Запись в адресной книге")
public class PersonDto {

    @ApiModelProperty(position = 1, value = "Идентификатор записи", example = "ed46b91d-fd6b-411a-9704-c26bdd79797e")
    private String id;
    @ApiModelProperty(position = 2, value = "Имя", example = "Иван")
    @NotEmpty(message = "name can't be null")
    private String name;
    @ApiModelProperty(position = 3, value = "Фамилия", example = "Иванов")
    @NotEmpty(message = "surname can't be null")
    private String surname;
    @ApiModelProperty(position = 4, value = "Отчество", example = "Иванович")
    private String patronymic;
    @ApiModelProperty(position = 5, value = "Прозвище", example = "")
    private String nick;

    @ApiModelProperty(position = 6, value = "Работа")
    private JobDto job;
    @ApiModelProperty(position = 7, value = "Список адресов")
    private List<AddressDto> addresses;
    @ApiModelProperty(position = 8, value = "Список контактов")
    private List<ContactDto> contacts;
    @ApiModelProperty(position = 9, value = "Список групп")
    private List<ContactGroupDto> myGroups;

}
