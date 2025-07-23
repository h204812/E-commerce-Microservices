package com.example.SpringMongo.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class observationConfig {
        @Bean
        ObservedAspect observedAspect(ObservationRegistry registry) {
            return new ObservedAspect(registry);
        }
}
