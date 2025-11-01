package com.br.EventClean.infrastruct.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    Optional<EventoEntity> findByIdentificador(String identificador);

    boolean existsByIdentificador(String identificador);
}
