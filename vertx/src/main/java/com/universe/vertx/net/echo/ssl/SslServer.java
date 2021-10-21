package com.universe.vertx.net.echo.ssl;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.streams.Pump;

/**
 * echo-ssl-server
 */
public class SslServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(SslServer.class);
    }

    @Override
    public void start() throws Exception {
        NetServerOptions options = new NetServerOptions().setSsl(true).setKeyStoreOptions(new JksOptions()
                .setPath("server-keystore.jks").setPassword("webble"));

        vertx.createNetServer().connectHandler(netSocket -> {
            Pump.pump(netSocket,netSocket).start();
        }).listen(1234);

        System.out.println("ssl server starting");
    }
}
