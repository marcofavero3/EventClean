package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public  CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return null;
    }
}
