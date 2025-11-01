package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.gateway.EventoGateway;

public class BuscarPorIdentificadorImp implements BuscarPorIdentificadorCase {
    private final EventoGateway eventoGateway;

    public BuscarPorIdentificadorImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarPorIdentificador(identificador);
    }
}
