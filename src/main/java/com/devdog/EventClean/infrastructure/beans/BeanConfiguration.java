package com.devdog.EventClean.infrastructure.beans;

import com.devdog.EventClean.core.gateway.EventoGateway;
import com.devdog.EventClean.core.usecases.CriarEventoUseCase;
import com.devdog.EventClean.core.usecases.CriarEventoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }
}
