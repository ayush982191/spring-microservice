package com.employee.address.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditConfig {
    @Bean
    public AuditorAware<Integer> auditorProvider(){
        return ()-> Optional.of(1);
    }
}