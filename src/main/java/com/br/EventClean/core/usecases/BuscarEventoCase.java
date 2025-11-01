package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;

public interface BuscarEventoCase {
    Evento execute(Long id);
}
