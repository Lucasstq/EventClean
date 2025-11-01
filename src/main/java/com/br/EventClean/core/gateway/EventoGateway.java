package com.br.EventClean.core.gateway;

import com.br.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento buscarEventPorId(Long id);

    Evento buscarPorIdentificador(String identificador);

    Evento criarEvento(Evento evento);

    void deletarEvento(Long id);

    List<Evento> listarTodos();

}
