package com.sterhov.rest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate(){ // данный класс используем для HTTP запросов
        return new RestTemplate();
    }
}
