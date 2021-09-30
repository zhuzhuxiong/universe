package com.universe.nacoscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author L
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosCustomerApplication.class, args);
    }

}
