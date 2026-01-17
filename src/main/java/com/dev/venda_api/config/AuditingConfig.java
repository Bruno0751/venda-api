package com.dev.venda_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

@Configuration
public class AuditingConfig {

    @Bean
    public AuditorAware<String> dateTimeProvider() {
        return () -> Optional.of("SYSTEM");
    }

}
