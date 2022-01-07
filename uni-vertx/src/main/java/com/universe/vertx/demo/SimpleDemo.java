package com.universe.vertx.demo;

import io.vertx.core.AbstractVerticle;
import org.springframework.beans.factory.annotation.Value;

import javax.naming.Name;

/**
 * @author L
 * 继承 AbstractVersicle start();
 * 运行：配置run configuration；
 *      application -- Main class：io.vertx.core.Launcher
 *      argument -- run com.universe.vertx.demo.SimpleDemo(类路径)
 *
 */
public class SimpleDemo extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().end("Hello");
        }).listen(8080);
    }
}
