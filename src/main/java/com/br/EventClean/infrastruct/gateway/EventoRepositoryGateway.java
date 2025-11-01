package com.br.EventClean.infrastruct.gateway;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.gateway.EventoGateway;
import com.br.EventClean.infrastruct.exceptions.EventoNotFoundException;
import com.br.EventClean.infrastruct.mapper.EventoEntityMapper;
import com.br.EventClean.infrastruct.persistence.EventoEntity;
import com.br.EventClean.infrastruct.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;

    @Override
    public Evento criarEvento(Evento evento) {
        //gera um identificador único antes de salvar o evento
        String identificador = gerarIdentificadorUnico();
        evento.setIdentificador(identificador);
        EventoEntity eventoEntity = EventoEntityMapper.toEntity(evento);
        EventoEntity eventoSalvo = eventoRepository.save(eventoEntity);
        return EventoEntityMapper.toDomain(eventoSalvo);
    }

    @Override
    public Evento buscarEventPorId(Long id) {
        EventoEntity eventoEncontrado = eventoRepository.findById(id)
                .orElseThrow(() -> new EventoNotFoundException("Evento não encontrado"));
        return EventoEntityMapper.toDomain(eventoEncontrado);
    }

    @Override
    public List<Evento> listarTodos() {
        List<EventoEntity> listaEventos = eventoRepository.findAll();
        return listaEventos.stream()
                .map(EventoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarEvento(Long id) {
        eventoRepository.findById(id)
                .orElseThrow(() -> new EventoNotFoundException("Evento não encotrado, não foi possivel excluir"));
        eventoRepository.deleteById(id);
    }

    @Override
    public Evento buscarPorIdentificador(String identificador) {
        EventoEntity eventoEncontrado = eventoRepository.findByIdentificador(identificador)
                .orElseThrow(() -> new EventoNotFoundException("Evento não encontrado, identificador não existe."));
        return EventoEntityMapper.toDomain(eventoEncontrado);
    }


    private String gerarIdentificadorUnico() {
        String identificador;
        do {
            identificador = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
        } while (eventoRepository.existsByIdentificador(identificador));
        return identificador;
    }

}
