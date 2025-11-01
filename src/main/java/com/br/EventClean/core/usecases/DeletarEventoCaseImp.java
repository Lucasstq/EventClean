package com.br.EventClean.core.usecases;

import com.br.EventClean.core.gateway.EventoGateway;

public class DeletarEventoCaseImp implements DeletarEventoCase {
    private EventoGateway eventoGateway;

    public DeletarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public void execute(Long id) {
        eventoGateway.deletarEvento(id);
    }
}
