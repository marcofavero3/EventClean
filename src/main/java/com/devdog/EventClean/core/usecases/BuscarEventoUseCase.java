package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarEventoUseCase {

    public List<Evento> execute();
}
