package ru.shvetsov.leonid.addressbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;


@RestControllerAdvice
public class ApplictionExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BusinessError.class)
    public HashMap<String, String> handleBusinessError (BusinessError e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getBusinessErrorInfo().getMessage());
        response.put("error", e.getBusinessErrorInfo().getCode());
        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleInvalidParameterException(RuntimeException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Некорректный запрос");
        response.put("error", e.getClass().getSimpleName());
        return response;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public HashMap<String, String> handleRuntimeError (Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Невозможно обработать запрос");
        response.put("error", e.getClass().getSimpleName());
        return response;
    }

}
