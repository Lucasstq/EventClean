package com.br.EventClean.infrastruct.exceptions;

public class EventoNotFoundException extends RuntimeException {
    public EventoNotFoundException(String message) {
        super(message);
    }
}
