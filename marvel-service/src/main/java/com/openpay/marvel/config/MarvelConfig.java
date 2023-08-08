package com.openpay.marvel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarvelConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
