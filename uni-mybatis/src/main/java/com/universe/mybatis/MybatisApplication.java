package com.universe.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybatis 相关问题demo
 * @author lx
 */
//扫描不到mapper会启动报错 == @mapper
@MapperScan("com/universe/mybatis/mapper/")
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
