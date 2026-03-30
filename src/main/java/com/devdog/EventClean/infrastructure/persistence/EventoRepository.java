package com.devdog.EventClean.infrastructure.persistence;

import com.devdog.EventClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository <EventoEntity, Long> {

    Optional<Evento> findByIdentificador(String identificador);

}
