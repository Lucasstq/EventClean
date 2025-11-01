package com.br.EventClean.infrastruct.presentation;

import com.br.EventClean.core.entities.Evento;
import com.br.EventClean.core.usecases.*;
import com.br.EventClean.infrastruct.dtos.EventoRequest;
import com.br.EventClean.infrastruct.dtos.EventoResponse;
import com.br.EventClean.infrastruct.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final ListarEventosCase listarEventosCase;
    private final DeletarEventoCase deletarEventoCase;
    private final BuscarPorIdentificadorCase buscarPorIdentificador;

    @PostMapping()
    public ResponseEntity<EventoResponse> criarEvento(@RequestBody EventoRequest eventoRequest) {
        Evento novoEvento = criarEventoCase.execute(EventoMapper.toEvento(eventoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(EventoMapper.toEventoResponse(novoEvento));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoResponse> buscarEvento(@PathVariable Long id) {
        Evento eventoEncontrado = buscarEventoCase.execute(id);
        return ResponseEntity.ok(EventoMapper.toEventoResponse(eventoEncontrado));
    }

    @GetMapping
    public ResponseEntity<List<EventoResponse>> buscarTodosEventos() {
        List<Evento> listaEventos = listarEventosCase.execute();
        return ResponseEntity.ok(listaEventos.stream()
                .map(EventoMapper::toEventoResponse)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        deletarEventoCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar-identificador")
    public ResponseEntity<EventoResponse> buscarIdentificadorEvento(@RequestParam String identificador) {
        Evento eventoEncontrado = buscarPorIdentificador.execute(identificador);
        return ResponseEntity.ok(EventoMapper.toEventoResponse(eventoEncontrado));
    }
}
