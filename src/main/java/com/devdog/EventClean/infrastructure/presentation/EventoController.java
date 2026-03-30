package com.devdog.EventClean.infrastructure.presentation;

import com.devdog.EventClean.core.entities.Evento;
import com.devdog.EventClean.core.usecases.BuscarEventoUseCase;
import com.devdog.EventClean.core.usecases.CriarEventoUseCase;
import com.devdog.EventClean.core.usecases.FiltrarIdentificadorUseCase;
import com.devdog.EventClean.core.usecases.FiltrarIdentificadorUseCaseImpl;
import com.devdog.EventClean.infrastructure.dtos.EventoDto;
import com.devdog.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final BuscarEventoUseCase buscarEventoUseCase;
    private final CriarEventoUseCase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;
    private final FiltrarIdentificadorUseCase filtrarIdentificadorUseCase;

    public EventoController(CriarEventoUseCase criarEventoUsecase, EventoDtoMapper eventoDtoMapper, BuscarEventoUseCase buscarEventoUseCase, FiltrarIdentificadorUseCase filtrarIdentificadorUseCase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.filtrarIdentificadorUseCase = filtrarIdentificadorUseCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem:", "Evento cadastrado com sucesso");
        response.put("Dados do evento:", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos() {
        return buscarEventoUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<Evento>
    buscarEventoPorIdentificador(@PathVariable String identificador) {
        Evento evento = filtrarIdentificadorUseCase.execute(identificador);
        return ResponseEntity.ok(evento);
    }
}