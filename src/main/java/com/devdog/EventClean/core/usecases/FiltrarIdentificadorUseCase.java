package com.devdog.EventClean.core.usecases;

import com.devdog.EventClean.core.entities.Evento;

public interface FiltrarIdentificadorUseCase {

    public Evento execute(String identificador);
}
