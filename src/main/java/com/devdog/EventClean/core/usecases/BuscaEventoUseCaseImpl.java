package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscaEventoUseCaseImpl implements BuscarEventoUseCase{

    private final EventoGateway eventoGateway;

    public BuscaEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarEventos();
    }
}
