package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;

public interface CriarEventoCase {
    Evento execute(Evento evento);
}
