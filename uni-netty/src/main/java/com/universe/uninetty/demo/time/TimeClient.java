package com.universe.uninetty.demo.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * client构建与server区别
 * 1、启动器：serverBootStrap 与 BootStrap
 * 2、channel： NIOServerSocketChannel 与 NIoSocketChannel
 * 3、handler、option: client 的bootStrap 没有父级，不设置child
 * 4、eventLoopGroup：client可以只有一个Group，既当boss 又当 worker
 * 5、bind（port） 与 connect（host,port）
 */
public class TimeClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TimeClientHandler());
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}
