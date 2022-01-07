package com.universe.vertx.demo.http.simple;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;

/**
 * @author
 */
public class HttpServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(HttpServer.class);
    }

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type","text/html")
                    .end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        }).listen(8080);
    }
}
