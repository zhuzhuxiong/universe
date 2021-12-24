package com.universe.vertx.http.simple;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;

/**
 * http 基础demo server
 * version  3.4.2-->4.1.2
 * 旧版本httpserver 启动 web访问没有响应  一直转啊转，改到 github上4.x版本后可以正常显示
 */
public class SimpleServer extends AbstractVerticle {

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(SimpleServer.class);
    }

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        }).listen(8080);
    }
}
