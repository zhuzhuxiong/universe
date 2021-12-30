package com.universe.uninetty.demo.fundamental.time.pojo;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimePojoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("TimePojoServerHandler-channelActive-start");
        ChannelFuture future = ctx.writeAndFlush(new TimePojo());
        future.addListener(ChannelFutureListener.CLOSE);
    }
}
