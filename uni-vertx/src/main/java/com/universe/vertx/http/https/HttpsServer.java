package com.universe.vertx.http.https;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

/**
 * https Server
 * TODO 连接拒绝
 */
public class HttpsServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(HttpsServer.class);
    }

    @Override
    public void start() throws Exception {
//        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setSsl(true).setKeyStoreOptions(
//                new JksOptions().setPath("server-keystore.jks").setPassword("wibble")
//        ));
//
//        server.requestHandler(req -> {
//            req.response().putHeader("content-type","text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
//        }).listen(4443);

        HttpServer server =
                vertx.createHttpServer(new HttpServerOptions().setSsl(true).setKeyStoreOptions(
                        new JksOptions().setPath("server-keystore.jks").setPassword("wibble")
                ));

        server.requestHandler(req -> {
            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        }).listen(8080);
    }

}
