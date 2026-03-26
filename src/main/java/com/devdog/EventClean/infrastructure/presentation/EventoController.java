package com.devdog.EventClean.infrastructure.presentation;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.usecases.CriarEventoUseCase;
import com.devdog.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUsecase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public String criarEvento(@RequestBody Evento evento){
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain());
    }
}
