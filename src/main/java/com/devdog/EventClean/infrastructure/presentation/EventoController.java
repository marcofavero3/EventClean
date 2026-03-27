package com.devdog.EventClean.infrastructure.presentation;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.usecases.BuscarEventoUseCase;
import com.devdog.EventClean.core.usecases.CriarEventoUseCase;
import com.devdog.EventClean.infrastructure.dtos.EventoDto;
import com.devdog.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final BuscarEventoUseCase buscarEventoUseCase;
    private final CriarEventoUseCase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUsecase, EventoDtoMapper eventoDtoMapper,  BuscarEventoUseCase buscarEventoUseCase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto){
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        return eventoDtoMapper.toDto(novoEvento);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos(){
        return buscarEventoUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
