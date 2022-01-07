package com.universe.vertx.demo;

import io.vertx.core.Vertx;

/**
 *
 * @author L
 * 一个访问输出 "Hello World" 的server
 *
 */
public class SimplestDemo {

    public static void main(String[] args) {
        Vertx.vertx().createHttpServer().requestHandler(req -> {
            req.response().end("Hello World");
        }).listen(8080);
    }
}
