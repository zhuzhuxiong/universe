package com.universe.nacoscustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerWebController {

//    @Autowired
//    private

    @GetMapping("/web/test")
    public String test(){
return "";

    }
}
