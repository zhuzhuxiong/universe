package com.universe.rocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RocketApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(RocketApplication.class, args);

        }catch (Exception e){
            log.info("e:",e);
        }

    }

}
