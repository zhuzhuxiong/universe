package com.universe.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
public class LoginController {

    @RequestMapping("/")
    public String index(){
        return  "I am in";
    }

}
