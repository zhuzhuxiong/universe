package com.universe.nacoscustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign 调用
 * 1、依赖（非Spring自己封装的）
 * 2、启动类 @EnableFeignClients-开启client扫描，
 * 3、@FeignClient("服务名")接口
 */
@RestController
public class CustomerFeignController {

    @Autowired
    Client client;

    @GetMapping("/feign")
    public String feignTest(){
        String test = client.test("123");
        return test;
    }
}

@FeignClient("discover-provider")
interface Client{

    @GetMapping("/echo/{string}")// feign根据对应Producer接口调用
    String test(@PathVariable String string);
}
