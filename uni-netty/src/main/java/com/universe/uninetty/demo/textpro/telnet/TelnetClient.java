package com.universe.uninetty.demo.textpro.telnet;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TelnetClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .handler(new TelnetClientInitializer());
            bootstrap.connect("127.0.0.1",8192).sync().channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }

    }
}
