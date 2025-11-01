package com.br.EventClean.infrastruct.persistence;

import com.br.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "tb_eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, name = "nome")
    private String nome;
    @Column(length = 255, name = "descricao")
    private String descricao;
    @Column(length = 100, unique = true, name = "identificador")
    private String identificador;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "data_inicio")
    private LocalDate inicio;
    @Column(name = "data_fim")
    private LocalDate fim;
    @Column(name = "capacidade")
    private Integer capacidade;
    @Column(name = "organizador")
    private String organizador;
    @Column(name = "local_evento")
    private String localEvento;

}
