package com.br.EventClean.infrastruct.config;

import com.br.EventClean.infrastruct.exceptions.EventoNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EventoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEventoNotFoundException(EventoNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if (ex.getMessage() != null) {
            if (ex.getMessage().contains("identificador")) {
                return new ResponseEntity<>("Idenficador já existe em outro evento. Coloque um identificador válido. ",
                        HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
