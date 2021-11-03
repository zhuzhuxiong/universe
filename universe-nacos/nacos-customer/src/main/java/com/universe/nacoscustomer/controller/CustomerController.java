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
 * @author 原始消费方式、拼接URL
 */
@Slf4j
@RestController
public class CustomerController {

   @Autowired
    LoadBalancerClient client;

   @GetMapping("/customer/test")
   public String test(){
       ServiceInstance instance = client.choose("discover-provider");
       RestTemplate restTemplate = new RestTemplate();
       String url = instance.getUri()+"/echo/hello";
       String object = restTemplate.getForObject(url, String.class);
       return instance.getUri()+object;
   }
}
