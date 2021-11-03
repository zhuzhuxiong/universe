package com.universe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author /
 */
@RestController
public class TestController {

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string){
        return "hello nacos world ---:" + string;
    }

    public static void main(String[] args) {
        Math.random();
    }
}
