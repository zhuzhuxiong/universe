package com.universe.vertx.http.simple;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;

public class SimpleClient extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(SimpleClient.class);
    }

    @Override
    public void start() throws Exception {

        HttpClient httpClient = vertx.createHttpClient();
        httpClient.request(HttpMethod.GET,8080,"localhost","/")
                .compose(httpClientRequest -> httpClientRequest.send())
                .compose(resp -> {
                    System.out.println("response:" + resp.statusCode());
                    return resp.body();
                }).onSuccess(buffer -> {
                    System.out.println("data:"+buffer.toString());
                }).onFailure(fail -> {
                    fail.printStackTrace();
                });
    }
}
