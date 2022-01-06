package com.universe.vertx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class VertxApplication {

    public static void main(String[] args) {
        SpringApplication.run(VertxApplication.class, args);
    }



}
