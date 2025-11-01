package com.br.EventClean.infrastruct.mapper;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.infrastruct.dtos.EventoRequest;
import com.br.EventClean.infrastruct.dtos.EventoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventoMapper {

    public static Evento toEvento(EventoRequest eventoRequest) {

        return Evento
                .builder()
                .nome(eventoRequest.nome())
                .descricao(eventoRequest.descricao())
                .tipoEvento(eventoRequest.tipoEvento())
                .inicio(eventoRequest.inicio())
                .fim(eventoRequest.fim())
                .capacidade(eventoRequest.capacidade())
                .organizador(eventoRequest.organizador())
                .localEvento(eventoRequest.localEvento())
                .build();

    }


    public static EventoResponse toEventoResponse(Evento evento) {

        return EventoResponse
                .builder()
                .id(evento.getId())
                .nome(evento.getNome())
                .descricao(evento.getDescricao())
                .identificador(evento.getIdentificador())
                .tipoEvento(evento.getTipoEvento())
                .inicio(evento.getInicio())
                .fim(evento.getFim())
                .capacidade(evento.getCapacidade())
                .organizador(evento.getOrganizador())
                .localEvento(evento.getLocalEvento())
                .build();

    }

}
