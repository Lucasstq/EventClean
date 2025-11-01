package com.br.EventClean.core.entities;

import com.br.EventClean.core.enums.TipoEvento;

import java.time.LocalDate;

public class Evento {

    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private TipoEvento tipoEvento;
    private LocalDate inicio;
    private LocalDate fim;
    private Integer capacidade;
    private String organizador;
    private String localEvento;

    //Não deixa ninguém instanciar evento antes de fazer Builder
    private Evento() {
    }

    // cria classe estatica Builder
    public static class Builder {
        private final Evento evento = new Evento();

        public Builder id(Long id) {
            evento.id = id;
            return this;
        }

        public Builder nome(String nome) {
            evento.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            evento.descricao = descricao;
            return this;
        }

        public Builder identificador(String identificador) {
            evento.identificador = identificador;
            return this;
        }

        public Builder tipoEvento(TipoEvento tipoEvento) {
            evento.tipoEvento = tipoEvento;
            return this;
        }

        public Builder inicio(LocalDate inicio) {
            evento.inicio = inicio;
            return this;
        }

        public Builder fim(LocalDate fim) {
            evento.fim = fim;
            return this;
        }

        public Builder capacidade(Integer capacidade) {
            evento.capacidade = capacidade;
            return this;
        }

        public Builder organizador(String organizador) {
            evento.organizador = organizador;
            return this;
        }

        public Builder localEvento(String localEvento) {
            evento.localEvento = localEvento;
            return this;
        }

        public Evento build() {
            return evento;
        }

    }

    //Metodo para criar builder nos dtos
    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public String getOrganizador() {
        return organizador;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }
}

