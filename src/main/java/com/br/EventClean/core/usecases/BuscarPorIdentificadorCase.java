package com.br.EventClean.core.usecases;

import com.br.EventClean.core.entities.Evento;

public interface BuscarPorIdentificadorCase {
    Evento execute(String identificador);
}
