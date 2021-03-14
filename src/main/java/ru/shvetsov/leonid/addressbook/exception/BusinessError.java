package ru.shvetsov.leonid.addressbook.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessError extends RuntimeException {
    BusinessErrorInfo businessErrorInfo;

}
