package com.universe.nacoscustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * webclient 调用
 *
 */
@RestController
public class CustomerWebController {

    @Autowired
    private WebClient.Builder webclient;

    @GetMapping("/web/test")
    public Mono<String> test() {
        Mono<String> mono = webclient.build()
                .get()
                .uri("http://discover-provider/echo/web")
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
}
