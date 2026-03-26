package com.devdog.EventClean.infrastructure.presentation;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.usecases.CriarEventoUseCase;
import com.devdog.EventClean.infrastructure.dtos.EventoDto;
import com.devdog.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

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
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto){
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        return eventoDtoMapper.toDto(novoEvento);
    }

//    @GetMapping
//    public String listarEventos(){
//
//    }
}
