package com.universe.uninetty.demo.fundamental.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 连接建立是被调用,即客户端上线，channel建立是触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer(4);
//        long mill = System.currentTimeMillis() / 1000L + 2208988800L;
        long mill = System.currentTimeMillis() / 1000000L;
        log.info("TimeServerHandler-mill:{}",mill);
        byteBuf.writeInt((int) (mill));
        byteBuf.writeBoolean(false);
        log.info("TimeServerHandler-byteBuf:{}",byteBuf);
        ChannelFuture future1 = ctx.writeAndFlush(byteBuf);
        future1.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                log.info("TimeServerHandler-future1：{},futrue:{}",future1,future);
                assert future1 == future;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
