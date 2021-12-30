package com.universe.uninetty.demo.textpro.telnet;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.util.Date;

@Slf4j
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("TelnetServerHandler-channelActive-start");
        ctx.write("welcome to" + InetAddress.getLocalHost().getHostName() + "!");
        ctx.write("now is" + new Date());
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("TelnetServerHandler-channelRead0-start");
        String response;
        boolean close = false;
        if (msg.isEmpty()){
            response = "I need sth";
        }else if ("bye".equals(msg.toLowerCase())){
            response = "see you";
            close = true;
        }else {
            response = "you say " + msg + " ?" ;
        }
        ChannelFuture future = ctx.write(response);
        if (close){
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("TelnetServerHandler-channelReadComplete-start");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("TelnetServerHandler-exceptionCaught-start");
        cause.printStackTrace();
        ctx.close();
    }
}
