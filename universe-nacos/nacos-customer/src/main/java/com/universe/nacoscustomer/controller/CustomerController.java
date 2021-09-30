package com.universe.nacoscustomer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author L
 */
@Slf4j
@RestController
public class CustomerController {

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/app")
    public String echoAppName(){
        ServiceInstance choose = loadBalancerClient.choose("discover-provider");
        String format = String.format("http://%s:%s/echo/%s", choose.getHost(), choose.getPort(), appName);
        log.info("echoappname--format:{}",format);
        return restTemplate.getForObject(format, String.class);
    }
}
