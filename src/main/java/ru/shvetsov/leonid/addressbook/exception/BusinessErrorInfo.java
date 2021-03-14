package ru.shvetsov.leonid.addressbook.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessErrorInfo {

    PERSON_ALREADY_CREATE("ER-1", "Запись с указанными именем и фамилией уже созданы");

    String code;
    String message;

}
