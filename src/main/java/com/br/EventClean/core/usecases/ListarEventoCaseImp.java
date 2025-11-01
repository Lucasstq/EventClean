package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class ListarEventoCaseImp implements ListarEventosCase {

    private EventoGateway eventoGateway;

    public ListarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.listarTodos();
    }
}
