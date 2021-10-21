package com.universe.vertx.net.echo;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.streams.Pump;

/**
 * echo 模式-server
 * Runner 抄自官网GitHub
 * telnet localhost 1212
 * 返回与发送相同的数据
 */
public class EchoServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(EchoServer.class);
    }

    @Override
    public void start() throws Exception {

        vertx.createNetServer().connectHandler(socket ->
                Pump.pump(socket,socket).start()).listen(1212);
        System.out.println("echo is starting");
    }
}
