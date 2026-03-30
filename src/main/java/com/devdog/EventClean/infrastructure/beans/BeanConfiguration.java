package com.devdog.EventClean.infrastructure.beans;

import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoUseCase buscarEvento(EventoGateway eventoGateway){
        return new BuscaEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorUseCase filtrarIdentificador(EventoGateway eventoGateway){
        return new FiltrarIdentificadorUseCaseImpl(eventoGateway);
    }
}
