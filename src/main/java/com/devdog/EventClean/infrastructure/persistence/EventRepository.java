package com.devdog.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <EventoEntity, Long> {

}
