package com.devdog.EventClean.infrastructure.gateway;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.infrastructure.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;

    @Override
    public Evento criarEvento(Evento evento) {
        return null;
    }
}
