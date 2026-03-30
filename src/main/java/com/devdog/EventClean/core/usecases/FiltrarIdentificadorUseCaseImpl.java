package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.infrastructure.exceptions.NotFoundEventException;

public class FiltrarIdentificadorUseCaseImpl implements FiltrarIdentificadorUseCase {

    private final EventoGateway eventoGateway;


    public FiltrarIdentificadorUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador)
                .orElseThrow(() ->
                        new NotFoundEventException("Evento com identificador: " + identificador + " não encontrado"));
    }
}
