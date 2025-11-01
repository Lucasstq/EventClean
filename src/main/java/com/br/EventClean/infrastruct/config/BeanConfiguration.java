package com.br.EventClean.infrastruct.config;

import com.br.EventClean.core.gateway.EventoGateway;
import com.br.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoCase criarEvento(EventoGateway eventoGateway) {
        return new CriarEventoCaseImp(eventoGateway);
    }

    @Bean
    public BuscarEventoCase buscarEvento(EventoGateway eventoGateway) {
        return new BuscarEventoCaseImp(eventoGateway);
    }

    @Bean
    public ListarEventosCase listarTodosEventos(EventoGateway eventoGateway) {
        return new ListarEventoCaseImp(eventoGateway);
    }

    @Bean
    public DeletarEventoCase deletarEvento(EventoGateway eventoGateway) {
        return new DeletarEventoCaseImp(eventoGateway);
    }

    @Bean
    public BuscarPorIdentificadorCase buscarPorIdentificador(EventoGateway eventoGateway) {
        return new BuscarPorIdentificadorImp(eventoGateway);
    }
}
