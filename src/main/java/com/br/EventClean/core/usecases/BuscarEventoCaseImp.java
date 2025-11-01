package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.gateway.EventoGateway;

public class BuscarEventoCaseImp implements BuscarEventoCase {

  private final EventoGateway eventoGateway;

    public BuscarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Long id) {
        return eventoGateway.buscarEventPorId(id);
    }
}
