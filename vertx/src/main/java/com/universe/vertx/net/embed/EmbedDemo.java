package com.universe.vertx.net.embed;

import io.vertx.core.Vertx;

/**
 * embed 嵌入式-请求默认返回 "hello world"
 * （我没看到返回）
 */
public class EmbedDemo {

    public static void main(String[] args) {
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
    }
}
