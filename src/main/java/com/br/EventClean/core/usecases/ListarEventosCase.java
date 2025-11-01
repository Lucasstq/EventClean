package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;

import java.util.List;

public interface ListarEventosCase {
    List<Evento> execute();
}
