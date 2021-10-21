package com.universe.vertx.net.echo.ssl;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;

/**
 * echo ssl client 类同 echo，使用ssl
 */
public class SslClient extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(SslClient.class);
    }

    @Override
    public void start() throws Exception {

        NetClientOptions options = new NetClientOptions().setSsl(true).setTrustAll(true);

        vertx.createNetClient().connect(1234,"localhost",socket -> {
            if (socket.succeeded()){
                NetSocket result = socket.result();
                result.handler(buffer -> {
                    System.out.println("ssl:" + buffer.toString());
                });

                for (int i = 0; i < 10; i++) {
                    String str = "hello" + i + "\n";
                    System.out.println("client :" + str);
                    result.write(str);
                }
            }else {
                System.out.println("fail :" + socket.cause() );
            }
        });
    }
}
