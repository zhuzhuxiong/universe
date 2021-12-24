package com.universe.vertx.http.https;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;

public class HttpsClient extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(HttpsClient.class);
    }

    @Override
    public void start() throws Exception {
        HttpClient client = vertx.createHttpClient(new HttpClientOptions().setSsl(true).setTrustAll(true));
        client.request(HttpMethod.GET,8080,"localhost","/")
                .compose(HttpClientRequest::send)
                .compose(resp -> {
                    System.out.println(resp.statusCode());
                    return resp.body();
                }).onSuccess(buffer -> {
                    System.out.println("body:"+buffer.toString());
                }).onFailure(Throwable::printStackTrace);
    }
}
