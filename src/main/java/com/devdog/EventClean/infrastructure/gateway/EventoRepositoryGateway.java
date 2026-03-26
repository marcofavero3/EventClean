package com.devdog.EventClean.infrastructure.gateway;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.infrastructure.mapper.EventoEntityMapper;
import com.devdog.EventClean.infrastructure.persistence.EventoEntity;
import com.devdog.EventClean.infrastructure.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper mapper;

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entity = mapper.toEntity(evento);
        EventoEntity novoEvento =  eventoRepository.save(entity);
        return  mapper.toDomain(novoEvento);
    }
}
