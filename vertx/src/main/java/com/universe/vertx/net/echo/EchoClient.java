package com.universe.vertx.net.echo;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetSocket;

/**
 * echo client
 *
 */
public class EchoClient extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(EchoClient.class);
    }

    @Override
    public void start() throws Exception {
        vertx.createNetClient().connect(1212,"localhost",res -> {
            if (res.succeeded()){
                NetSocket socket = res.result();
                socket.handler(buffer -> System.out.println("client:" + buffer.toString()));

                for (int i = 0; i < 10; i++) {
                    String str = "hello" + i + "\n";
                    System.out.println("net client " + str);
                    socket.write(str);
                }
            }else {
                System.out.println(res.cause());
            }
        });
    }
}
