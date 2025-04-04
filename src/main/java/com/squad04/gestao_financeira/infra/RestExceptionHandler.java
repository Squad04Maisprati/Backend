package com.squad04.gestao_financeira.infra;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<String> transactionNotFoundHandler (NoSuchElementException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TRANSAÇÃO NÃO ENCONTRADA");
    }



}
