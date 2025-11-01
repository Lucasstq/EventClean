package com.br.EventClean.infrastruct.mapper;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.infrastruct.persistence.EventoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventoEntityMapper {

    public static Evento toDomain(EventoEntity evento) {
        return Evento
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

    public static EventoEntity toEntity(Evento evento) {
        return EventoEntity
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
