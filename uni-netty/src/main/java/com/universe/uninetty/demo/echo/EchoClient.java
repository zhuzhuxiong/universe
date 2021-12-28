package com.universe.uninetty.demo.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;

public class EchoClient {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));
    static final int PORT = Integer.parseInt(System.getProperty("port", "8080"));
    static final String HOST = System.getProperty("host", "127.0.0.1");

    static SslContext sslContext = null;
    public static void main(String[] args) throws CertificateException, SSLException {
        if (SSL){
            SelfSignedCertificate certificate = new SelfSignedCertificate();
            sslContext = SslContextBuilder.forClient().
                    trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        }else {
            sslContext = null;
        }
        new EchoClient().run();

    }

    public void run() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            if (sslContext != null){
                                p.addLast(sslContext.newHandler(ch.alloc(),HOST,PORT));
                            }
                            p.addLast(new EchoClientHandler());
                        }
                    })
                    .option(ChannelOption.TCP_NODELAY, true);
            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
