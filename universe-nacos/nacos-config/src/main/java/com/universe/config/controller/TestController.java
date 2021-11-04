package com.universe.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos 配置中心
 * 2、spring.application.name 与 配置的一至
 * 3、@RefreshScope 动态刷新 配置修改 程序响应
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${config.demo}")
    private String title;

    @GetMapping("/test")
    public String testConfig(){
        return title;
    }
}
