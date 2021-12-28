package com.universe.uninetty.demo.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

/**
 * discard server demo
 * demo内容来自官网，应该是需要client 及 clientHandler 的
 */
public class DiscardServer {

//    static final boolean SSL = System.getProperty("ssl") != null;
//    static final int port = Integer.parseInt(System.getProperty("port","8080"));

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws CertificateException, SSLException {
        int port = 8080;
        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        new DiscardServer(port).run();
        //次要 ssl
//        final SslContext sslContext;
//        if (SSL) {
//            SelfSignedCertificate certificate = new SelfSignedCertificate();
//            sslContext = SslContextBuilder.forServer(certificate.certificate(),certificate.privateKey()).build();
//        }else {
//            sslContext = null;
//        }
//
//        new DiscardServer().run();
    }

    /**
     * 主要逻辑
     */
    public void run() {
        // accepts an incoming connection
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new DiscardServerHandler());
                }
            });
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            //针对 NioServerSockerChannel
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
