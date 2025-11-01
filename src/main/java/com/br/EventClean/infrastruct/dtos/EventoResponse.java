package com.br.EventClean.infrastruct.dtos;

import com.br.EventClean.core.enums.TipoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EventoResponse(Long id,
                             String nome,
                             String descricao,
                             String identificador,
                             TipoEvento tipoEvento,
                             @JsonFormat(pattern = "dd-MM-yyyy")
                             LocalDate inicio,
                             @JsonFormat(pattern = "dd-MM-yyyy")
                             LocalDate fim,
                             Integer capacidade,
                             String organizador,
                             String localEvento) {
}
