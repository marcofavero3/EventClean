package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.infrastructure.exceptions.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {

        if (eventoGateway.existePorIdentificador(evento.identificador())){
            throw new DuplicateEventException
                    ("O identificador numero: " + evento.identificador() + " já está em uso");
        }

        return eventoGateway.criarEvento(evento);
    }
}
