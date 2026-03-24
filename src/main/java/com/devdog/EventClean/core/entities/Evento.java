package com.devdog.EventClean.core.entities;

import com.devdog.EventClean.core.enuns.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String local,
        String organizador,
        TipoEvento tipo
) {
}
