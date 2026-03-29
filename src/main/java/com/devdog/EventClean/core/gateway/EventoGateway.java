package com.devdog.EventClean.core.gateway;

import com.devdog.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento criarEvento(Evento evento);
    List<Evento> buscarEventos();
    boolean existePorIdentificador(String identificador);
}
