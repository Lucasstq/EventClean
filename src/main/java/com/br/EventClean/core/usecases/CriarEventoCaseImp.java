package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.gateway.EventoGateway;

public class CriarEventoCaseImp implements CriarEventoCase {

    private EventoGateway eventoGateway;

    public CriarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
