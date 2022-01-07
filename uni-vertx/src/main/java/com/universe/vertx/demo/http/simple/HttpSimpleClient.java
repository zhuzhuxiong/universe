package com.universe.vertx.demo.http.simple;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;

/**
 * @author
 */
public class HttpSimpleClient extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(HttpSimpleClient.class);
    }

    @Override
    public void start() throws Exception {
        HttpClient client = vertx.createHttpClient();
        client.request(HttpMethod.GET, 8080, "localhost", "/")
                .compose(req -> req.send()
                        .compose(resp -> {
                            System.out.println("Got response " + resp.statusCode());
                            return resp.body();
                        }).onSuccess(buffer -> {
                            System.out.println("Got data " + buffer.toString("ISO-8859-1"));
                        }).onFailure(Throwable::printStackTrace));
    }
}
